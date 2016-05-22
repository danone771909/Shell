package shellApplication.commandImpl;

import java.io.IOException;

import shellApplication.CommandInterface.*;
import shellApplication.PathManager.PathCommand;
import shellApplication.cosoleoutput.ConsoleOutput;

public class CDCommand implements ICommand{

	private PathCommand pathCommand;
	private ConsoleOutput consoleOutput;
	
	public CDCommand(PathCommand pathCommand, ConsoleOutput consoleOutput)
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
	public boolean execute(String[] command) throws IOException
	{
		switch(command[1])
		{
			case "..":
				pathCommand.changeToParentDirectory();
				break;
			
			default:
				pathCommand.setCurrentDirectory(command[1]);
				break;	
		}
		consoleOutput.print();
		return true;
	}
}
