package sprite.character.enemy;

import sprite.character.enemy.ai.BossOne;
import sprite.character.player.Player;
import sprite.item.Item;

public class RobotBoss extends Boss{

	public RobotBoss(String spriteName, String fileName, double xLocation, double yLocation, double health,
			double speed, double width, double height, Item weapon, Player player, String enemyType, Item[] wepArr) {
		super(spriteName, fileName, xLocation, yLocation, health, speed, width, height, weapon, player, enemyType, wepArr);
		this.setBrain(new BossOne(this,this.getPlayer()));
	}

}
