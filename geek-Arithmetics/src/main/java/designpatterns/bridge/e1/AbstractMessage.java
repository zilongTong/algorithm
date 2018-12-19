package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public abstract class AbstractMessage {

	private MessageImplementor implementor;

	public AbstractMessage(MessageImplementor implementor) {
		super();
		this.implementor = implementor;
	}
	
	public boolean sendMessage(String toUser, String message) {
		if(implementor.checkMessage(message)) {
			return this.implementor.send(toUser, message);
		} else {
			System.out.println("【error】消息包含非法信息！");
			System.out.println("\t" + message);
			return false;
		}
	}
}
