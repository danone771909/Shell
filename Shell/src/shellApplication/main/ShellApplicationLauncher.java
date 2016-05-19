package shellApplication.main;

import java.io.IOException;
import shellApplication.prompt.Prompt;

public class ShellApplicationLauncher {

    public static void main(String[] args) throws IOException { 
    	
        Prompt prompt = new Prompt();
        
        while(true)
        {
        	if(!prompt.run())
        		break;
        }
    } 
}
