package sprite.item.shield;

import sprite.item.Item;

public class Shield extends Item
{
	private double rechargeDelay;
	private double rechargeRate;
	private double currentShieldAmount;
	private double defaultShieldAmount;
	private boolean isRechargeable;
	
	public Shield(String spriteName, String fileName, double xLocation, double yLocation, String itemType,
			boolean isCooledDown, double coolDownTime, double width, double height, double rechargeDelay, double rechargeRate, double shieldAmount) 
	{
		super(spriteName, fileName, xLocation, yLocation, itemType, isCooledDown, coolDownTime, width, height);
		this.rechargeDelay = rechargeDelay;
		this.rechargeRate = rechargeRate;
		this.currentShieldAmount = shieldAmount;
		this.defaultShieldAmount = shieldAmount;
		isRechargeable = true;
	}
	
	public void runShield(double seconds)
	{
		
	}
	
	
	
	
}
