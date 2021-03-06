package map.obstacle;

import mainGame.GameRunner;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.item.LootGen;

public class Shop extends Obstacle
{
	private Item onSale;
	public Shop(double width, double height, double xPos, double yPos, double faceAngle,int levelNum) {
		super("Shop", "file:resources/obstacle/table.png", width, height, xPos, yPos, faceAngle);
		onSale=LootGen.randomShopItem(this,levelNum);
	}
	
	public Item buyItem(Player player)
	{
		if(!(player.getInventory().isInventoryFull())&&onSale!=null && player.getCoins()>=onSale.getCost())
		{
			player.addCoins(-onSale.getCost());
			Item bought=onSale;
			onSale=null;
			return bought;
		}
		return null;
	}

	public Item getOnSale() {
		return onSale;
	}

	public void setOnSale(Item onSale) {
		this.onSale = onSale;
	}
	
	
}
