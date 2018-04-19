package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;
import sprite.item.weapon.Fist;

public class Player extends Character
{
	
	private String spriteName;
	private int currentItemIdx;
	private Item[] inventory = new Item[6];
	private int score;
	private int currentAmmo;
	private int defaultAmmo;
	
	public Player(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double health, double speed, Item[] inventory, int ammoCount) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width,height);
		this.inventory = inventory;
		//this.inventory[0] = new Fist();
		currentItemIdx = 0;
		this.changeSelectedItem(inventory[currentItemIdx]);
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
		Item remove = inventory[currentItemIdx];
		inventory[currentItemIdx] = null;
		return remove;
	}
	
	public boolean isInventoryFull()
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] == null)
				return false;
		return true;
	}
	
	@Override
	public void useSelectedItem(String input) 
	{
		if(input.equals(Item.POTION)&&inventory[currentItemIdx].getItemType().equals(Item.POTION) || input.equals(Item.WEAPON)&&inventory[currentItemIdx].getItemType().equals(Item.WEAPON))
		{
			inventory[currentItemIdx].useItem();
		}
	}
	
	public void selectItem(String input)
	{
		currentItemIdx = Integer.parseInt(input);
	}
	
	public int getCurrentItemIdx()
	{
		return currentItemIdx;
	}
	
	public Item getCurrentItem()
	{
		return inventory[currentItemIdx];
	}
	
	public int getCurrentAmmo() {return currentAmmo;}
	public int getDefaultAmmo() {return defaultAmmo;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public void setCurrentAmmo(int currentAmmo) {this.currentAmmo = currentAmmo;}
	public Item[] getInventory() {return inventory;}
	
	public void setCurrentItemIdx(int currentItemIdx)
	{
		this.currentItemIdx = currentItemIdx;
	}
	
	public String toString()
	{
		String output = "";
		output += "Sprite Name = " + spriteName + "\n"
				   +"X Coords = " + getXLocation() + "\n"
				   +"Y Coords = " + getYLocation() + "\n"
			       +"Health = " + getCurrentHealth() + "\n"
			       +"Speed = " + getSpeed() + "\n"
			       +"Selected Item Index = " + currentItemIdx + "\n";
		return output;
	}
}
