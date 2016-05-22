package shellApplication.PathManager;

import java.io.File;
import java.io.IOException;

import shellApplication.pathinterface.PathInterface;
import shellApplication.utils.StringProcessor;

public class PathManager implements PathInterface {
	
	private String currentPath;
	
	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	public PathManager() {
		File f = new File("");
		currentPath = f.getAbsolutePath();
	}
	
	@Override
	public boolean changeToParentDirectory() throws IOException
	{
    	File f = new File( currentPath ).getCanonicalFile().getParentFile();
    	if(f==null)
    	{
    		System.out.println("No such directory");
    		return false;
    	}		
    	currentPath = f.getCanonicalPath();
    	return true;
	}
	
	@Override
	public boolean setCurrentDirectory(String path) throws IOException
	{
    	File root = new File ( currentPath );
    	File[] list = root.listFiles();
    	
        for ( File f : list ) {
            if ( f.isDirectory() ) 
            { 
            	String canonicalPath = f.getCanonicalPath();
            	String lastDirectoryName = StringProcessor.getLastDirectoryName(canonicalPath);
                if ( lastDirectoryName.equals(path))
                {   	
                	currentPath = canonicalPath;
                	return true;
                } 
            } 
        } 
        System.out.println("No such directory");
        return false;
	}
}

