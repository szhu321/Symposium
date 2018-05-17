package sprite.item.collectable;

import sprite.item.Item;

public class Coin extends Item
{
	private int amount;
	
	public Coin(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, int amount)
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, Item.COIN);
		this.amount = amount;
	}

	public int getAmount()
	{
		return amount;
	}
	
	public String toString()
	{
		return "Coin: Amount = " + amount + ".";
	}
}
