package shellApplication.finder;

import java.io.File;
import java.io.IOException;

public class PathFinder {

    private void find( String path ) 
    { 
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
    
    public void showTreeNode(String path, int node)
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
    
    public String getPathToCurrentDirectory() throws IOException
    {
    	String current = new File( "." ).getCanonicalPath();
    	return current;
    }
    
    public void dir() throws IOException
    {
    	String current = new File( "." ).getCanonicalPath();
    	find(current);
    }
    
    public void tree() throws IOException
    {
    	String current = new File( "." ).getCanonicalPath();
    	showTreeNode(current, 0);
    }
    
    public boolean changeToParent() throws IOException
    {
    	File f = new File( "." ).getCanonicalFile().getParentFile();
    	if(f==null)
    		return false;
    	String parent = f.getCanonicalPath();
    	return setCurrentDirectory(parent);
    }
    
    public boolean setCurrentDirectory(String directory_name)
    {
        boolean result = false;  // Boolean indicating whether directory was set
        File directory;       // Desired current working directory

        directory = new File(directory_name).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs())
        {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }

        return result;
    }
}