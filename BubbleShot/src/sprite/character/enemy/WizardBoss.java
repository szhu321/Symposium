package sprite.character.enemy;

import java.util.List;

import sprite.character.enemy.ai.BossOne;
import sprite.character.enemy.ai.BossThree;
import sprite.character.enemy.ai.BossTwo;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.weapon.Weapon;

public class WizardBoss extends Boss{

	private List<Weapon> ice;
	private List<Weapon> dark;
	private List<Weapon> fire;
	public WizardBoss(String spriteName, String fileName, double xLocation, double yLocation, double health,
			double speed, double width, double height, Item weapon, Player player, String enemyType, List<Weapon> wepArr,List<Weapon> wepArr2,List<Weapon> wepArr3) {
		super(spriteName, fileName, xLocation, yLocation, health, speed, width, height, weapon, player, enemyType, wepArr);
		ice=wepArr2;
		dark=wepArr3;
		fire=wepArr;
		this.setBrain(new BossThree(this,this.getPlayer()));
	}
	public void switchElement(int num)
	{
		if(num==0)
			this.setAllWep(fire);
		if(num==1)
			this.setAllWep(ice);
		if(num==2)
			this.setAllWep(dark);
	}
}
