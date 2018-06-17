package mainGame.saving;

import java.io.*;

import sprite.character.player.Player;

public class FileSaver
{
	
	public static void savePlayer(Player player)
	{
		createPlayerSavesFolder();
		ObjectOutputStream objstream = null;
		try 
		{
			objstream = new ObjectOutputStream(new FileOutputStream(new File("saves/players/" + player.getSpriteName() + ".dat")));
			objstream.writeObject(player);
			//System.out.println("success");
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
	
	public static void createPlayerSavesFolder()
	{
		File file = new File("saves");
		if(!file.exists())
		{
			file.mkdirs();
			//System.out.println("saves directory was successfully created.");
		}
		
		File file2 = new File("saves/players");
		if(!file2.exists())
		{
			file2.mkdirs();
			//System.out.println("saves/players directory was successfully created.");
		}
	
	}
}
