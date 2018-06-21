package mainGame.saving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import myutilities.FileUtil;
import sprite.character.player.Player;

public class FileDeleter
{
	
	public static void deletePlayer(Player player)
	{
		File[] files = FileUtil.getAllDatFilesFromDir("saves/players");
		if(files != null)
		{
			for(int i = 0; i < files.length; i++)
			{
				if(files[i].getName().equals(player.getSpriteName() + ".dat"))
				{
					files[i].delete();
					return;
				}
			}
		}	
	}
}
