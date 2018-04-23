package sprite.item.ammo;

import sprite.item.Item;

public class Ammo extends Item
{
	int currentAmmo;
	
	public Ammo(String spriteName, String fileName, double xLocation, double yLocation, 
			String itemType, boolean isCooledDown, double coolDownTime, double width, 
			double height, int ammo) 
	{
		super(spriteName, fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, 
				width, height);
		currentAmmo = ammo;
	}

	@Override
	public boolean useItem() 
	{
		currentAmmo--;
		return false;
	}
	
}
