package dm.cmd;
/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class SpeakCommand implements Command {
	
	private Receiver receiver;

	public SpeakCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public boolean execute() {
		if(receiver == null) {
			System.out.println("no one can speak!");
			return false;
		}
		return receiver.action();
	}

}
