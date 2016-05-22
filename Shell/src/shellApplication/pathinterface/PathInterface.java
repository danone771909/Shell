package shellApplication.pathinterface;

import java.io.IOException;

public interface PathInterface {

	public boolean setCurrentDirectory(String path) throws IOException;
	public boolean changeToParentDirectory() throws IOException;
}
