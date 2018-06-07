package sprite.character.enemy;

import java.util.List;

import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.Weapon;

public abstract class Boss extends Enemy
{
	private List<Weapon> allWep;
	boolean followPlayer;
	
	public Boss(String spriteName, String fileName, double xLocation, double yLocation, double health, double speed,
			double width, double height, Item weapon, Player player, String enemyType, List<Weapon> wepArr) {
		super(spriteName, fileName, xLocation, yLocation, health, speed, width, height, weapon, player, enemyType);
		allWep=wepArr;
	}

	public void switchWeapon(int wepNum)
	{
		this.setWeapon(allWep.get(wepNum));
	}
}
