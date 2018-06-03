package mainGame.saving;

import java.io.*;

import myutilities.FileUtil;
import sprite.character.player.Player;

public class FileReader
{
	public static Player[] loadPlayer()
	{
		ObjectInputStream objstream = null;
		File[] files = FileUtil.getAllDatFilesFromDir("saves/players");
		
		//System.out.println(files.length);
		//return null;
		Player[] players = new Player[files.length];
		for(int i = 0; i < players.length; i++)
		{
			try 
			{
				objstream = new ObjectInputStream(new FileInputStream(files[i]));
				try
				{
					players[i] = (Player)objstream.readObject();
					players[i].reloadObject();
					//System.out.println("successfully loaded player : " + i);
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					objstream.close();
				} 
				catch (IOException e) 
				{
					
					e.printStackTrace();
				}
			}
		}
		return players;
	}
}
