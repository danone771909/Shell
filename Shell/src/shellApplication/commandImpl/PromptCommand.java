package shellApplication.commandImpl;

import java.io.IOException;

import shellApplication.CommandInterface.ICommand;
import shellApplication.PathManager.PathCommand;
import shellApplication.cosoleoutput.ConsoleOutput;

public class PromptCommand implements ICommand {

	private ConsoleOutput consoleOutput;
	
	public PromptCommand(PathCommand pathCommand, ConsoleOutput consoleOutput)
	{
		initialize(pathCommand, consoleOutput);
	}
	
	@Override
	public void initialize(PathCommand pathCommand, ConsoleOutput consoleOutput) 
	{
		this.consoleOutput = consoleOutput;
	}
	
	@Override
	public boolean execute(String[] command) throws IOException 
	{	
		switch(command[1])
		{
			case "$cwd":
				consoleOutput.setOutputMode("path");
				break;
				
			case "reset":
				consoleOutput.setCursor("[MyShell] $>");
				break;
			
			default:
				consoleOutput.setOutputMode("normal");
				consoleOutput.setCursor("[MyShell] " + command[1]+">");
				break;
		}
		consoleOutput.print();
		return true;
	}
}
