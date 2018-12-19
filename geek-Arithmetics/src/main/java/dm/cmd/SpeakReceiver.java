package dm.cmd;
/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class SpeakReceiver implements Receiver {

	@Override
	public boolean action() {
		System.out.println("soldiers, let's go fighting!!");
		return true;
	}

}
