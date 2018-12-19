package rpc.simpledemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import org.apache.commons.lang3.StringUtils;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RpcFrameWork {


    /**
     * 暴露服务
     *
     * @param service
     * @param port
     * @throws Exception
     */
    public static void export(final Object service, int port) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("service instance == null");
        }
        if (port <= 0 || port >= 65535) {
            throw new IllegalArgumentException("invalid pot " + port);
        }
        System.out.println("Export service " + service.getClass().getName() + "on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                            String methodName = inputStream.readUTF();
                            Class<?>[] paramsTypes = (Class<?>[]) inputStream.readObject();
                            Object[] args = (Object[]) inputStream.readObject();
                            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                            try {
                                Method method = service.getClass().getMethod(methodName, paramsTypes);
                                Object result = method.invoke(service, args);
                                outputStream.writeObject(result);
                            } catch (Exception e) {

                            } finally {
                                inputStream.close();
                                outputStream.close();
                            }
                        } catch (Exception e) {

                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("interface class is null");
        }
        if (StringUtils.isEmpty(host) || port <= 0 || port >= 65535) {
            throw new IllegalArgumentException("invalid host or port");
        }
        System.out.println("Get remote service " + interfaceClass.getName() + "from server" + host + ":" + port);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host, port);
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        outputStream.writeUTF(method.getName());
                        outputStream.writeObject(method.getParameterTypes());
                        outputStream.writeObject(args);
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        try {
                            Object result = inputStream.readObject();
                            if (result instanceof Throwable) {
                                throw (Throwable) result;
                            }
                            return result;
                        } catch (Exception e) {

                        } finally {
                            inputStream.close();
                            outputStream.close();
                            socket.close();
                        }
                    } catch (Exception e) {

                    }
                } catch (Exception e) {
                }
                return null;
            }
        });
    }

}
