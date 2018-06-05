package sprite.character.enemy;

import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.Weapon;

public abstract class Boss extends Enemy
{
	private Item[] allWep;
	
	public Boss(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed,
			double width, double height, Item weapon, Player player, String enemyType, Item[] wepArr) {
		super(spriteName, fileName, xLocation, yLocation, health, speed, width, height, weapon, player, enemyType);
		allWep=wepArr;
	}

	public void switchWeapon(int wepNum)
	{
		this.setWeapon(allWep[wepNum]);
	}
}
