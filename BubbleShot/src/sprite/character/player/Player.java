package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;
import sprite.item.weapon.Fist;

public class Player extends Character
{
	
	String spriteName, weapon;
	int xLocation, yLocation, health, speed;
	Item[] inventory = new Item[6];
	int currentItem;
	
	public Player(String fileName, double xLocation, double yLocation, int health, int speed, 
			 Item[] inventory) 
	{
		super(fileName, xLocation, yLocation, health, speed, 60.0,60.0);
		this.inventory = inventory;
		this.inventory[0] = new Fist();
		currentItem=0;
		this.setSelectedItem(inventory[currentItem]);
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
	
	public Item removeItem()
	{
		Item remove=inventory[currentItem];
		inventory[currentItem]=null;
		return remove;
	}
	
	@Override
	public void useSelectedItem(String input) 
	{
		if(input.equals(Item.POTION)&&inventory[currentItem].getItemType().equals(Item.POTION) || input.equals(Item.WEAPON)&&inventory[currentItem].getItemType().equals(Item.WEAPON))
		{
			inventory[currentItem].useItem();
		}
	}
	
	public void selectItem(String input)
	{
		currentItem=Integer.parseInt(input);
	}
}
