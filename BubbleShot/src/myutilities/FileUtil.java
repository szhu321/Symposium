package myutilities;

import java.io.*;

public class FileUtil
{
	
	/**
	 * Finds files in a directory and returns them
	 * @param url The abstract location of the directory starting from the root folder.
	 * @return A array of png's that is in the directory.
	 */
	public static File[] getAllPngFilesFromDir(String url)
	{
		File file = new File(url);
		if(!file.isDirectory())
			return null;
		File[] files = file.listFiles(new FileFilter() 
		{
			@Override
			public boolean accept(File file)
			{
				String path = file.getPath().toString();
				if(path.substring(path.length() - 3).equals("png"))
					return true;
				return false;
			}
		});
		return files;
	}
	
	public static File[] getAllDatFilesFromDir(String url)
	{
		File file = new File(url);
		if(!file.isDirectory())
			return null;
		File[] files = file.listFiles(new FileFilter() 
		{
			@Override
			public boolean accept(File file)
			{
				String path = file.getPath().toString();
				if(path.substring(path.length() - 3).equals("dat"))
					return true;
				return false;
			}
		});
		return files;
	}

}
