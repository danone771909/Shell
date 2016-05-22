package shellApplication.main;

import java.io.IOException;

import shellApplication.CommandManager.CommandManager;

public class ShellApplicationLauncher {

    public static void main(String[] args) throws IOException { 
    	
        CommandManager commandManager = new CommandManager();

        while(true)
        {
        	if(!commandManager.run())
        		break;
        }
    } 
}
