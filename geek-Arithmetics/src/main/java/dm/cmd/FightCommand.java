package dm.cmd;
/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class FightCommand implements Command {
	
	private Receiver receiver;
	
	public FightCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public boolean execute() {
		if(receiver == null) {
			throw new RuntimeException("receiver is null");
		}
		return receiver.action();
	}

}
