package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public interface MessageImplementor {
	
	public boolean checkMessage(String message);

	public boolean send(String toUser, String message);
}
