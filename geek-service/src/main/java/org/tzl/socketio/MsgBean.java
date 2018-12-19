/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: MsgBean.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-10-10 07 : 09:26
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-10-10 07 : 09:26> <version>   <desc>
 */

package org.tzl.socketio;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author :tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MsgBean {
    private String from;
    private String to;
    private String content;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgBean [from=" + from + ", to=" + to + ", content=" + content + "]";
    }
}

