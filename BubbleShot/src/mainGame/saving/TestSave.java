package mainGame.saving;

import java.io.*;

import map.Level;
import map.LevelDesign;
import sprite.bounds.BoxCollider;

public class TestSave
{

	public static void main(String[] args)
	{
//		File file = new File("resources/slash/slash.png");
//		if(file.exists())
//		{
//			System.out.println("The text " + file.getName() + " exists");
//		}
//		else
//		{
//			System.out.println("Doesnt exists");
//		}
		
		BoxCollider obj = new BoxCollider(10, 10, 10, 10, 0);
		ObjectOutputStream objstream = null;
		
		try //"C:\\Users\\Sheng\\Desktop\\boxcollider.dat"
		{
			objstream = new ObjectOutputStream(new FileOutputStream(new File("saves/levels/boxcollider.dat")));
			objstream.writeObject(obj);
			System.out.println("Success");
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
