package sprite.item.ammo;

import sprite.item.Item;

public class Ammo extends Item
{
	int currentAmmo = 35;
	
	public Ammo(String spriteName, String fileName, double xLocation, double yLocation, 
			String itemType, boolean isCooledDown, double coolDownTime, double width, 
			double height) 
	{
		super(spriteName, fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, 
				width, height);
	}

	@Override
	public void useItem() 
	{
		currentAmmo--;
	}
	
}
