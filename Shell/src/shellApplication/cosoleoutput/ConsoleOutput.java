package shellApplication.cosoleoutput;

import shellApplication.PathManager.PathCommand;

public class ConsoleOutput {
	
	private enum OutputMode {normal, path};
	private OutputMode outputMode = OutputMode.normal;
	
	private PathCommand pathCommand;
	private String cursor = "[MyShell] $>";
	
	public ConsoleOutput(PathCommand pathCommand)
	{
		this.pathCommand = pathCommand;
	}
	
	public void print()
	{
		switch(outputMode)
		{
			case normal:
				System.out.print(cursor);
				break;
			case path:
				String current = pathCommand.getCurrentPath();
				System.out.print("[MyShell] " + current + ">");
				break;
		}		
	}
	
	public void setCursor(String cursor)
	{
		this.cursor = cursor;
	}
	
	public void setOutputMode(String mode)
	{
		switch(mode)
		{
			case "normal":
				outputMode = OutputMode.normal;
				break;
				
			case "path":
				outputMode = OutputMode.path;
				break;
		}
	}
}
