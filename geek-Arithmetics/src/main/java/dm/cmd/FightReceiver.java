package dm.cmd;
/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class FightReceiver implements Receiver {

	@Override
	public boolean action() {
		System.out.println("soldiers are fighting now!");
		return true;
	}

}
