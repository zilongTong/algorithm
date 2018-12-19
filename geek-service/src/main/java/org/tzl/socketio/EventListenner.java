/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: EventListenner.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-10-10 06 : 50:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-10-10 06 : 50:07> <version>   <desc>
 */

package org.tzl.socketio;



import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
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
@Service("eventListenner")
public class EventListenner {
    @Resource(name = "clientCache")
    private SocketIOClientCache clientCache;

    @Resource(name = "socketIOResponse")
    private SocketIOResponse socketIOResponse;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        System.out.println("建立连接");
    }

    @OnEvent("OnMSG")
    public void onSync(SocketIOClient client, MsgBean bean) {
        System.out.printf("收到消息-from: %s to:%s\n", bean.getFrom(), bean.getTo());
        clientCache.addClient(client, bean);
        SocketIOClient ioClients = clientCache.getClient(bean.getTo());
        System.out.println("clientCache");
        if (ioClients == null) {
            System.out.println("你发送消息的用户不在线");
            return;
        }
        socketIOResponse.sendEvent(ioClients, bean);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("关闭连接");
    }
}