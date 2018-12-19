package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class MessageSMSImplementor extends AbstractMessageImplementor {

	@Override
	public boolean  send(String toUser, String message) {
		System.out.println("使用[站内信]发送消息给：" + toUser + "，内容：" + message);
		return true;
	}

	@Override
	public boolean checkMessage(String message) {
		//站内信不进行信息校验，覆盖父类的校验方法
		return true;
	}
}
