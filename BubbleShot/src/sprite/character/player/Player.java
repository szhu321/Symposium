package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;
import sprite.item.weapon.Fist;

public class Player extends Character
{
	
	String spriteName;
	int xLocation, yLocation, health, speed, currentItem;
	Item[] inventory = new Item[6];
	
	public Player(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, int health, int speed, 
			 Item[] inventory) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width,height);
		this.inventory = inventory;
		//this.inventory[0] = new Fist();
		currentItem = 0;
		this.changeSelectedItem(inventory[currentItem]);
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
	
	public String toString()
	{
		String output = "";
		output += "Sprite Name = " + spriteName + "\n"
				   +"X Coords = " + xLocation + "\n"
				   +"Y Coords = " + yLocation + "\n"
			       +"Health = " + health + "\n"
			       +"Speed = " + speed + "\n"
			       +"Selected Item Index = " + currentItem + "\n";
		return output;
	}
}
