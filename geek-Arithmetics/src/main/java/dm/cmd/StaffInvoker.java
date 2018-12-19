package dm.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Smile.Wu
 * @version 2015-9-25
 */
public class StaffInvoker implements Invoker {
	
	private List<Command> commands;
	
	public StaffInvoker() {
		commands = new ArrayList<>();
	}

	@Override
	public boolean action() {
		if(commands == null || commands.size() < 1) {
			throw new RuntimeException("no avaliable commands");
		}
		for(Command command : commands) {
			command.execute();
		}
		return true;
	}

	public void addCommand(Command c) {
		if(c != null) {
			commands.add(c);
		}
	}
}
