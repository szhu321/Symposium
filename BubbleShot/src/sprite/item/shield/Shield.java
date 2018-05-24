package sprite.item.shield;

import sprite.item.Item;

public class Shield extends Item
{
	private double currentRechargeDelay;
	private double defualtRechargeDelay;
	private double rechargeRate;
	private double currentShieldAmount;
	private double defaultShieldAmount;
	private boolean shieldDown;
	
	public Shield(String spriteName, String fileName, double xLocation, double yLocation, 
		 double width, double height, String itemType, double rechargeDelay, double rechargeRate, double shieldAmount) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, Item.ARMOR);
		this.currentRechargeDelay = rechargeDelay;
		this.defualtRechargeDelay = rechargeDelay;
		this.rechargeRate = rechargeRate;
		this.currentShieldAmount = shieldAmount;
		this.defaultShieldAmount = shieldAmount;
		shieldDown = false;
	}
	
	public void runShield(double seconds)
	{
		//First Check to see if the recharge delay is completed before recharging the shield.
		currentRechargeDelay += seconds;
		if(currentRechargeDelay < defualtRechargeDelay)
			return;
		else
			currentRechargeDelay = defualtRechargeDelay;
		//If the recharge delay is completed recharge the shield.
		currentShieldAmount += rechargeRate * seconds;
		if(currentShieldAmount > defaultShieldAmount)
			currentShieldAmount = defaultShieldAmount;
	}
	
	//When the currentShildAmount is set turn currentRechargeDelay to 0.
	public void setCurrentShieldAmount(double currentShieldAmount)
	{
		this.currentShieldAmount = currentShieldAmount;
		if(currentShieldAmount <= 0)
		{
			shieldDown = true;
			currentShieldAmount = 0;
		}
		else
		{
			shieldDown = false;
		}
		currentRechargeDelay = 0;
	}

	public boolean isShieldDown()
	{
		return shieldDown;
	}
	
	public double getCurrentShieldAmount() 
	{
		return currentShieldAmount;
	}

	public double getDefualtRechargeDelay() 
	{
		return defualtRechargeDelay;
	}

	public double getDefaultShieldAmount()
	{
		return defaultShieldAmount;
	}
	
}
