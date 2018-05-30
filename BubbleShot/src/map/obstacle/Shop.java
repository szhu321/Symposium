package map.obstacle;

import sprite.item.Item;

public class Shop extends Obstacle
{
	private Item onSale;
	public Shop(String name, String fileName, double width, double height, double xPos, double yPos, double faceAngle) {
		super("Shop", "file:resources/obstacle/table.png", width, height, xPos, yPos, faceAngle);
		
	}

}
