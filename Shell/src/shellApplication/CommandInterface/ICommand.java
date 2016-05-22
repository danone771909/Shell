package shellApplication.CommandInterface;

import java.io.IOException;

import shellApplication.PathManager.PathCommand;
import shellApplication.cosoleoutput.ConsoleOutput;

public interface ICommand 
{
	public void initialize(PathCommand pathCommand, ConsoleOutput consoleOutput);
	public boolean execute(String[] command) throws IOException;
}
