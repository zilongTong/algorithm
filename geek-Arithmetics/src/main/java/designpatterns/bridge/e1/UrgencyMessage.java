package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class UrgencyMessage extends AbstractMessage {

	public UrgencyMessage(MessageImplementor implementor) {
		super(implementor);
	}

	@Override
	public boolean sendMessage(String toUser, String message) {
		message = "【加急】" + message;
		if(super.sendMessage(toUser, message)) {
			System.out.println("【加急】发送成功！");
			otherOperate(toUser, message);
			return true;
		} else {
			System.out.println("【加急】发送失败！");
		}
		return false;
	}
	
	private void otherOperate(String toUser, String message) {
		System.out.println("加急消息特殊处理：");
		System.out.println("\t-定时提醒：" + toUser);
		System.out.println("\t-多次发送：" + message);
	}
}
