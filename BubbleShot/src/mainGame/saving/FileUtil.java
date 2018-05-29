package mainGame.saving;

import java.io.*;

public class FileUtil
{
	public static File[] getAllFilesFromDir(String url)
	{
		File dir = new File(url);
		if(!dir.isDirectory())
			return null;
		return dir.listFiles();
	}
}
