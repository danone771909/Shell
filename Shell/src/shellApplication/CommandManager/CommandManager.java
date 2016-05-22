package shellApplication.CommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import shellApplication.CommandInterface.ICommand;
import shellApplication.commandfactory.CommandFactory;

public class CommandManager {
	
	private CommandFactory commandFactory = new CommandFactory();
	
	private boolean selectCommand(String command) throws IOException
	{
		ICommand commandExecutor;
		String[] splitedCommand = splitCommand(command);
		commandExecutor = commandFactory.makeCommand(splitedCommand[0]);
		return commandExecutor.execute(splitedCommand);
	}
	
	private String[] splitCommand(String command)
	{	
		String[] commands = command.trim().split("\\s+");
		return commands;
	}
	
	public boolean run() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String value = in.readLine();
		
		if(value!=null)
		{
			return selectCommand(value);
		}
		return true;
	}
}
