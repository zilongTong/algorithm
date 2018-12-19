package dm.cmd;
/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class TestCommand {

	public static void main(String[] args) {
		Invoker staffInvoker = new StaffInvoker();
		
		Command speak = new SpeakCommand(new SpeakReceiver());
		Command fight = new FightCommand(new FightReceiver());
		
		staffInvoker.addCommand(speak);
		staffInvoker.addCommand(fight);
		
		staffInvoker.action();
	}
}
