package shellApplication.commandfactory;

import java.util.HashMap;

import shellApplication.CommandInterface.ICommand;
import shellApplication.PathManager.PathCommand;
import shellApplication.cosoleoutput.ConsoleOutput;
import shellApplication.commandImpl.CDCommand;
import shellApplication.commandImpl.PromptCommand;
import shellApplication.commandImpl.StandardCommand;

public class CommandFactory {
	private HashMap<String, ICommand> commands = new HashMap<>();
	private PathCommand pathCommand = new PathCommand();
	private ConsoleOutput consoleOutput = new ConsoleOutput(pathCommand);
	
	public CommandFactory()
	{
		consoleOutput.print();
	}
	
	public ICommand makeCommand(String name)
	{
		if(commands.containsKey(name))
		{
			return commands.get(name);
		}
		else
		{
			ICommand command = null;
			switch (name)
			{
				case "cd":
					command = new CDCommand(pathCommand, consoleOutput);
					break;
	
				case "prompt":
					command = new PromptCommand(pathCommand, consoleOutput);
					break;
	
				default:
					command = new StandardCommand(pathCommand, consoleOutput);
					break;
			}
			commands.put(name, command);
			return command;
		}
	}
}
