package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 * 
 * 统一验证
 */
public abstract class AbstractMessageImplementor implements MessageImplementor {

	@Override
	public boolean checkMessage(String message) {
		if(message == null || message.length() < 0) {
			return false;
		}
		if(message.contains("天朝")) {
			return false;
		}
		return true;
	}
}
