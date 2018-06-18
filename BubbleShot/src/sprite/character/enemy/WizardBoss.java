package sprite.character.enemy;

import java.util.List;

import sprite.character.enemy.ai.BossOne;
import sprite.character.enemy.ai.BossThree;
import sprite.character.enemy.ai.BossTwo;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.Weapon;

public class WizardBoss extends Boss{

	public WizardBoss(String spriteName, String fileName, double xLocation, double yLocation, double health,
			double speed, double width, double height, Item weapon, Player player, String enemyType, List<Weapon> wepArr) {
		super(spriteName, fileName, xLocation, yLocation, health, speed, width, height, weapon, player, enemyType, wepArr);
		this.setBrain(new BossThree(this,this.getPlayer()));
	}

}
