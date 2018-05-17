package sprite.item.collectable;

import java.util.ArrayList;
import java.util.List;

public class CoinDesign
{
	public static Coin getCoinOne(double x, double y)
	{
		return new Coin("", "file:resources/coin/coin1.png", x, y, 30, 30, 1);
	}
	
	public static Coin getCoinFive(double x, double y)
	{
		return new Coin("", "file:resources/coin/coin5.png", x, y, 30, 30, 5);
	}
	
	public static List<Coin> getCoinStack(int amount)
	{
		List<Coin> coins = new ArrayList<Coin>();
		int amountleft = amount;
		while(amountleft >= 5)
		{
			coins.add(getCoinFive(0, 0));
			amountleft -= 5;
		}
		
		while(amountleft > 0)
		{
			coins.add(getCoinOne(0, 0));
			amountleft --;
		}
		
		return coins;
	}
}
