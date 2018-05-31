package sprite.item.collectable;

import sprite.character.player.Player;
import sprite.item.Item;

public class Coin extends Item implements InstantCollect
{
	private int amount;
	
	public Coin(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, int amount)
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, Item.COIN,0);
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

	@Override
	public void collect(Player player) 
	{
		player.setCoins(player.getCoins() + amount);
		
	}
}
