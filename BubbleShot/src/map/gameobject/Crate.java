package map.gameobject;

import javafx.scene.image.Image;
import sprite.item.Item;

public class Crate extends BreakableObject
{
	private Item[] loot;
	
	public Crate(String spriteName, String fileName, double xLocation, double yLocation, double width, double height,
			double faceAngle) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, faceAngle);
		// TODO Auto-generated constructor stub
	}

}
