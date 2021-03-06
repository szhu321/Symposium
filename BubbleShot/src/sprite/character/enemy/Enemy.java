package sprite.character.enemy;

import mainGame.backend.Constants;
import mainGame.frontend.HealthBar;
import map.Level;
import map.Room;
import sprite.character.Character;
import sprite.character.enemy.ai.AI;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.LootGen;
import sprite.item.weapon.Weapon;

public abstract class Enemy extends Character
{
	private Item weapon;
	private int killPoints;
	private AI brain;
	private Player player;
	private HealthBar healthbar;
	private String enemyType;
	private double circleRadius;
	private boolean canDropItem;
	public static final String FOLLOWER="follower";
	public static final String SMART="smart";
	public static final String GHOST="ghost";
	public static final String SWORD="sword";
	public static final String MELEE="melee";
	public static final String MACHINEGUN="machinegun";
	public static final String TOWER="tower";
	public static final String SPAWNER1="spawner1";
	public static final String SPAWNER2="spawner2";
	public static final String ROBOTBOSS="robotboss";
	
	public Enemy(String spriteName,String fileName, double xLocation, double yLocation, double health, double speed,
			double width, double height,Item weapon,Player player,String enemyType) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width, height);
		this.weapon=weapon;
		this.weapon.setPossessor(this);
		this.player=player;
		healthbar = new HealthBar(70, 5, getCurrentHealth());
		this.enemyType=enemyType;
		circleRadius=400;
		canDropItem=true;
	}
	
	public int getKillPoints(){return killPoints;}
	public Player getPlayer() {return player;}
	public void setKillPoints(int killPoints){this.killPoints=killPoints;}
	public AI getBrain(){return brain;}
	public void setBrain(AI brain){this.brain=brain;}
	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}

	public Item getWeapon()	{return weapon;}
	public void setWeapon(Item wep)	{weapon=wep;}
	public HealthBar getHealthbar() {return healthbar;}
	
	@Override
	public void setCurrentHealth(double currentHealth) 
	{
		healthbar.updateCanvas(currentHealth, getDefaultHealth());
		super.setCurrentHealth(currentHealth);
	}

	@Override
	public void useCurrentItem(String input) 
	{
		((Weapon) weapon).useItem();
	}
	
	@Override
	public void coolDownWeapons(double sec)
	{
		((Weapon)weapon).coolDownItem(sec);
	}
	
	public Item dropItem(int levelNum)
	{
		return LootGen.randomEnemyItem(this,levelNum);
	}

	public double getCircleRadius() {
		return circleRadius;
	}

	public void setCircleRadius(double circleRadius) {
		this.circleRadius = circleRadius;
	}
	
	public void addCircleRadius(double circleRadius) {
		this.circleRadius += circleRadius;
	}
	
	public void calculateEnemyAngleToPlayer()
	{
		double distanceX = (player.getXLocation()+(player.getWidth()/2)) - this.getXLocation() - this.getWidth()/2;
		double distanceY = (player.getYLocation()+(player.getHeight()/2)) - this.getYLocation() - this.getHeight()/2;
		double enemyAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
		if(distanceY <= 0 && distanceX < 0)
			enemyAngle += 180;
		else if(distanceY > 0 && distanceX < 0)
			enemyAngle = 90 + (90 - Math.abs(enemyAngle));
		else if(distanceX > 0 && distanceY < 0)
			enemyAngle += 360;
		this.setFaceAngle(enemyAngle);
	}

	public boolean isCanDropItem() {
		return canDropItem;
	}

	public void setCanDropItem(boolean canDropItem) {
		this.canDropItem = canDropItem;
	}
}
