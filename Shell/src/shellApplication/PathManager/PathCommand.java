package shellApplication.PathManager;

import java.io.File;
import java.io.IOException;

public class PathCommand extends PathManager{
	
    public void dir() throws IOException
    {
    	String current = getCurrentPath();
    	find(current);
    }
    
    public void tree() throws IOException
    {
    	String current = getCurrentPath();
    	showTreeNode(current, 0);
    }
    
    public void exit()
    {
    	System.out.println("Bye");
    }
    
    public void unknownCommand(String val)
    {
    	System.out.println(val + " : unknown command");
    }
    
    private void showTreeNode(String path, int node)
    {
    	File root = new File ( path );
    	File[] list = root.listFiles();
    	
    	String nodeS="";
    	for(int i=0; i<node; i++)
    		nodeS+="-";
    	
        for ( File f : list ) { 
            if ( f.isDirectory() ) 
            { 
            	System.out.println( nodeS + f.getAbsoluteFile() ); 
            	showTreeNode( f.getAbsolutePath(), node+1);         
            } 
        } 
    }
    
    private void find( String path ) 
    { 
    	System.out.println("Content of " + path);
        File root = new File( path ); 
        File[] list = root.listFiles(); 

        for ( File f : list ) 
        { 
            if ( f.isDirectory() ) 
            { 
                System.out.println( "DIR\t" + f.getAbsoluteFile() ); 
            } 
            else { 
                System.out.println( "FILE\t" + f.getAbsoluteFile() ); 
            } 
        } 
    } 
}
