package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;
import sprite.item.weapon.Fist;

public class Player extends Character
{
	
	private String spriteName;
	private int currentItem;
	private Item[] inventory = new Item[6];
	private int score;
	private int currentAmmo;
	private int defaultAmmo;
	
	public Player(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, int health, int speed, Item[] inventory, int ammoCount) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width,height);
		this.inventory = inventory;
		//this.inventory[0] = new Fist();
		currentItem = 0;
		this.changeSelectedItem(inventory[currentItem]);
		score = 0;
		currentAmmo = ammoCount;
		defaultAmmo = ammoCount;
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
	
	public int getCurrentItem()
	{
		return currentItem;
	}
	
	public int getCurrentAmmo() {return currentAmmo;}
	public int getDefaultAmmo() {return defaultAmmo;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public void setCurrentAmmo(int currentAmmo) {this.currentAmmo = currentAmmo;}

	public void setCurrentItem(int currentItem)
	{
		this.currentItem = currentItem;
	}
	
	public String toString()
	{
		String output = "";
		output += "Sprite Name = " + spriteName + "\n"
				   +"X Coords = " + getXLocation() + "\n"
				   +"Y Coords = " + getYLocation() + "\n"
			       +"Health = " + getCurrentHealth() + "\n"
			       +"Speed = " + getSpeed() + "\n"
			       +"Selected Item Index = " + currentItem + "\n";
		return output;
	}
}
