package sprite.item.ammo;

import sprite.item.Item;
import sprite.character.Character;
import sprite.character.player.Player;
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
		Character character = this.getPossessor();
		((Player)character).setCurrentAmmo(((Player)character).getCurrentAmmo() + currentAmmo);
		return false;
	}
	
}
