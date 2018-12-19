package rpc.zookeeper;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;


/**
 * jobclient docker改造
 * 注册应用信息至zookeeper
 */
public class ZkDockerService {

    private CuratorClient zkClient;

    private Set<String> zkPathList = new HashSet<String>();
    // 失败重试定时器，定时检查是否有请求失败，如有，无限次重试
    private ScheduledFuture<?> retryFuture;
    // 定时任务执行器
    private final ScheduledExecutorService retryExecutor = Executors.newScheduledThreadPool(1,
        new NamedThreadFactory("RegistryFailedRetryTimer", true));
    //需要重新注册的数据
    private Set<ClientData> retrySet = new HashSet<ClientData>();
    private String ZOOKEEPER_ADDRESS = "";

    /**
     * init-method，初始化执行
     * 将本机docker的IP地址 端口都注册到zookeeper中
     */
    public void register2Zookeeper() {
        try {
            zkClient = CuratorClient.getInstance(ZOOKEEPER_ADDRESS);
            ClientData client = findClientData();
            registerClientData(client);
            zkClient.addStateListener(new ZkStateListener() {
                @Override
                public void reconnected() {
                    ClientData client = findClientData();
                    //将服务添加到重试列表
                    retrySet.add(client);
                }
            });
            //启动线程进行重试，1秒执行一次，因为jobcenter的定时触发时间最短的是1秒
            this.retryFuture = retryExecutor.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    // 检测并连接注册中心
                    try {
                        retryRegister();
                    } catch (Throwable t) { // 防御性容错
                    }
                }
            }, 1, 1, TimeUnit.SECONDS);

        } catch (Exception e) {
        }
    }

    /**
     * destrory-method,销毁时执行
     */
    public void destroy4Zookeeper() {
        try {
            if (retryFuture != null) {
                retryFuture.cancel(true);
            }

        } catch (Throwable t) {
        }

        if (zkPathList != null && zkPathList.size() > 0) {
            for (String path : zkPathList) {
                try {
                    //  zkClient.delete(path);
                } catch (Exception e) {
                }
            }
        }
        zkClient.close();
    }

    /**
     * 构造要存储的对象
     **/
    private ClientData findClientData() {
        ClientData client = new ClientData();
        client.setIpAddress("127.0.0.1");
        client.setPort(111);
        client.setSource(1);
        return client;
    }

    /**
     * 将值写入zookeeper中
     **/
    private void registerClientData(ClientData client) throws Exception {
        String centerPath = "/server";
        String content = "";
        String strServer = zkClient.writeNode(centerPath, content, CreateMode.EPHEMERAL_SEQUENTIAL);
        if (!StringUtils.isBlank(strServer)) {
            zkPathList.add(strServer);
        }
    }

    /**
     * 重连到zookeeper时，自动重试
     */
    protected synchronized void retryRegister() {
        if (!retrySet.isEmpty()) {
            Set<ClientData> retryClients = new HashSet<ClientData>(retrySet);
            for (ClientData data : retryClients) {
                try {
                    //registerJobcenterClient(data);
                    retrySet.remove(data);
                } catch (Exception e) {
                }
            }
        }
    }


    private class ClientData {
        private String ipAddress;
        private int port;
        private int source;

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }
    }
}
