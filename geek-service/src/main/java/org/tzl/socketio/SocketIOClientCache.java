/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: SocketIOClientCache.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-10-10 07 : 07:43
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-10-10 07 : 07:43> <version>   <desc>
 */

package org.tzl.socketio;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.corundumstudio.socketio.SocketIOClient;
import org.springframework.stereotype.Service;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("clientCache")
public class SocketIOClientCache {
    //String：EventType类型
    private Map<String,SocketIOClient> clients=new ConcurrentHashMap<String,SocketIOClient>();

    //用户发送消息添加
    public void addClient(SocketIOClient client,MsgBean msgBean){
        clients.put(msgBean.getFrom(),client);
    }

    //用户退出时移除
    public void remove(MsgBean msgBean) {
        clients.remove(msgBean.getFrom());
    }

    //获取所有
    public  SocketIOClient getClient(String to) {
        return clients.get(to);
    }
}