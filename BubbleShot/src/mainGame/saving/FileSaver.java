package mainGame.saving;

import java.io.*;

import sprite.character.player.Player;

public class FileSaver
{
	
	public static void savePlayer(Player player)
	{
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
}
