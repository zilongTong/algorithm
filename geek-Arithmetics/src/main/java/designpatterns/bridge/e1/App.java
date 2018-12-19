package designpatterns.bridge.e1;
/**
 *
 * @author Smile.Wu
 * @version 2015-10-16
 */
public class App {

	public static void main(String[] args) {
		MessageImplementor mobile = new MessageMobileImplementor();
		String messageContent = "演示天朝麒麟臂训练成果！";
		String toUser = "队长";
		
		AbstractMessage common = new CommonMessage(mobile);
		common.sendMessage(toUser, messageContent);
		System.out.println();
		
		common = new UrgencyMessage(mobile);
		common.sendMessage(toUser, messageContent);
		System.out.println();
		
		MessageImplementor sms = new MessageSMSImplementor();
		common = new CommonMessage(sms);
		common.sendMessage(toUser, messageContent);
		System.out.println();

		common = new UrgencyMessage(sms);
		common.sendMessage(toUser, messageContent);
		System.out.println();
	}
}
