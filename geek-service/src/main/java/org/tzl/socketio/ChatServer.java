/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: ChatServer.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-10-10 07 : 08:18
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-10-10 07 : 08:18> <version>   <desc>
 */

package org.tzl.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//继承InitializingBean，使Spring加载完配置文件，自动运行如下方法
@Service("chatServer")
public class ChatServer implements InitializingBean {
    @Resource
    private EventListenner eventListenner;
    @Override
    public void afterPropertiesSet() throws Exception {
        Configuration config = new Configuration();
        config.setPort(9098);

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        config.setSocketConfig(socketConfig);
        config.setHostname("localhost");

        SocketIOServer server = new SocketIOServer(config);
        server.addListeners(eventListenner);
        server.start();
        System.out.println("启动正常");
    }
}