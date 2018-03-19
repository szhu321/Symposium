package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;

public class Player extends Character
{
	String spriteName, weapon;
	int xLoaction, yLocation, health, speed;
	Item[] inventory = new Item[6];
	
	protected Player(String fileName, int xLocation, int yLocation, int health, int speed, 
			String weapon, Item[] inventory) 
	{
		super(fileName, xLocation, yLocation, health, speed, weapon);
		this.inventory = inventory;
	}
	
	public void addItem(Item newItem)
	{
		int currentIndex = 0;
		while(currentIndex < inventory.length)
		{
			if(inventory[currentIndex] == null)
			{
				inventory[currentIndex] = newItem;
				break;
			}
			
			currentIndex++;
		}
	}
	
	
}
