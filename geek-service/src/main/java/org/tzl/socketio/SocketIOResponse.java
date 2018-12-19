/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: SocketIOResponse.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-10-10 07 : 07:17
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-10-10 07 : 07:17> <version>   <desc>
 */

package org.tzl.socketio;

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
@Service("socketIOResponse")
public class SocketIOResponse {
    public void sendEvent(SocketIOClient client, MsgBean bean) {
        System.out.println("推送消息");
        client.sendEvent("OnMSG", bean);
    }
}