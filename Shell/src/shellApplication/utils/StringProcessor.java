package shellApplication.utils;

public class StringProcessor {
	public static String getLastDirectoryName(String path)
	{
		String[] arr = path.split("\\\\");
		return arr[arr.length-1];
	}
}
