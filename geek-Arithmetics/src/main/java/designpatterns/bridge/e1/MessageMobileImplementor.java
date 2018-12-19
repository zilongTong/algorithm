package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class MessageMobileImplementor extends AbstractMessageImplementor {

	@Override
	public boolean send(String toUser, String message) {
		System.out.println("使用[手机]发送消息给：" + toUser + "，内容：" + message);
		return true;
	}

}
