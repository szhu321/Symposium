package myutilities;

import java.io.*;

public class FileUtil
{
	/**
	 * Finds files in a directory and returns them
	 * @param url The abstract location of the directory starting from the root folder.
	 * @return A array of files that is in the directory.
	 */
	public static File[] getFilesFromDir(String location, String type)
	{
		File file = new File(location);
		if(!file.isDirectory())
			return null;
		File[] files = file.listFiles(new FileFilter() 
		{
			@Override
			public boolean accept(File file)
			{
				String path = file.getPath().toString();
				if(path.substring(path.length() - 3).equals(type))
					return true;
				return false;
			}
		});
		return files;
	}
}
