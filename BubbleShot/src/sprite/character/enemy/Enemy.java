package sprite.character.enemy;

import mainGame.backend.Constants;
import mainGame.frontend.HealthBar;
import map.Level;
import map.Room;
import sprite.character.Character;
import sprite.character.enemy.ai.AI;
import sprite.character.player.Player;
import sprite.item.Item;

public abstract class Enemy extends Character
{
	private Item weapon;
	private int killPoints;
	private AI brain;
	private Player player;
	private HealthBar healthbar;
	
	public Enemy(String spriteName,String fileName, double xLocation, double yLocation, double health, double speed,
			double width, double height,Item weapon,Player player) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height);
		this.weapon=weapon;
		this.weapon.setPossessor(this);
		this.player=player;
		healthbar = new HealthBar(70, 5, getCurrentHealth());
	}
	
	public int getKillPoints(){return killPoints;}
	public Player getPlayer() {return player;}
	public void setKillPoints(int killPoints){this.killPoints=killPoints;}
	public AI getBrain(){return brain;}
	public void setBrain(AI brain){this.brain=brain;}
	public Item getWeapon()	{return weapon;}
	public HealthBar getHealthbar() {return healthbar;}
	
	@Override
	public void setCurrentHealth(double currentHealth) 
	{
		healthbar.updateCanvas(currentHealth);
		super.setCurrentHealth(currentHealth);
	}

	@Override
	public void useCurrentItem(String input) 
	{
		weapon.useItem();
	}
	
	public void coolDownWeapons(double sec)
	{
		weapon.coolDownItem(sec);
	}
	
}
