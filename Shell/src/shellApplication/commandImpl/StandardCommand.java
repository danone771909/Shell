package shellApplication.commandImpl;

import java.io.IOException;

import shellApplication.CommandInterface.ICommand;
import shellApplication.PathManager.PathCommand;
import shellApplication.cosoleoutput.ConsoleOutput;

public class StandardCommand implements ICommand{
	
	private PathCommand pathCommand;
	private ConsoleOutput consoleOutput;
	
	public StandardCommand(PathCommand pathCommand, ConsoleOutput consoleOutput)
	{
		initialize(pathCommand, consoleOutput);
	}
	
	@Override 
	public void initialize(PathCommand pathCommand, ConsoleOutput consoleOutput)
	{
		this.pathCommand = pathCommand;
		this.consoleOutput = consoleOutput;
	}
	
	@Override
	public boolean execute(String[] command) throws IOException {
		
		switch(command[0])
		{
			case "dir":
				pathCommand.dir();
				break;
				
			case "tree":
				pathCommand.tree();
				break;
				
			case "exit":
				pathCommand.exit();
				return false;
				
			default:
				pathCommand.unknownCommand(command[0]);
				break;
		}
		
		consoleOutput.print();
		return true;
	}
}
