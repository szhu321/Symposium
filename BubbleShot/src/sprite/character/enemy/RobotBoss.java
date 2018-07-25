package sprite.character.enemy;

import java.util.List;

import sprite.character.enemy.ai.BossOne;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.Weapon;

public class RobotBoss extends Boss{

	public RobotBoss(String spriteName, String fileName, double xLocation, double yLocation, double health,
			double speed, double width, double height, Item weapon, Player player, String enemyType, List<Weapon> wepArr) {
		super(spriteName, fileName, xLocation, yLocation, health, speed, width, height, weapon, player, enemyType, wepArr);
		this.setBrain(new BossOne(this,this.getPlayer()));
	}

}
