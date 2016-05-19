package shellApplication.prompt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import shellApplication.finder.PathFinder;

public class Prompt 
{
	PathFinder finder = new PathFinder();
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String cursor = IConsoleVariables.cursor;
	
	public Prompt()
	{
		System.out.print(IConsoleVariables.shell + IConsoleVariables.cursor);
	}
	
	public boolean run() throws IOException
	{
		String value = in.readLine();
    	if(value != null)
    	{
    		if(value.equals(IConsoleVariables.dir))
    		{
    			finder.dir();
    		}
    		
    		else if(value.equals(IConsoleVariables.tree))
    		{
    			finder.tree();
    		}
    		
    		else if(value.equals(IConsoleVariables.exit))
    		{
    			System.out.println("Bye");
    			return false;
    		}
    		
    		else if(value.length()>1 && value.substring(0, 2).equals(IConsoleVariables.cd))
    		{
    			if(value.length()>2 && value.substring(2, 3).equals(IConsoleVariables.space))
    			{
    				if(value.length()>4 && value.substring(3,5).equals(IConsoleVariables.dots))
    				{
    					//Change to parent
    					finder.changeToParent();
    				}
    				else
    				{
    					//Change to subdirectory
    					finder.setCurrentDirectory(value.substring(3, value.length()));
    				}
    			}
    		}
    		else if(value.length()>5 && value.substring(0, 6).equals(IConsoleVariables.prompt))
    		{
    			if(value.length()>6 && value.substring(6, 7).equals(IConsoleVariables.space))
    			{
    				if(value.length()>10 && value.substring(7, 11).equals(IConsoleVariables.cwd))
    				{
    					System.out.print(IConsoleVariables.shell + finder.getPathToCurrentDirectory() + ">");
    					return true;
    				}					
    				else if(value.length()>11 && value.substring(7, 12).equals(IConsoleVariables.reset))
    				{
    					cursor = IConsoleVariables.cursor;
    				}
    				else
    				{
    					cursor = value.substring(7, value.length()) + ">";
    				}
    			}
    		}
    		else
    		{
    			for(int i=0; i<value.length();i++)
    			{
    				if(value.charAt(i) == ' ')
    				{
    					System.out.println(value.substring(0, i) + " : " + IConsoleVariables.unknown);
    					System.out.print(IConsoleVariables.shell + cursor);
    					return true;
    				}
    			}
    			System.out.println(value +  " : " + IConsoleVariables.unknown);
    		}

    		System.out.print(IConsoleVariables.shell + cursor);
    	} 
    	return true;
	}
}