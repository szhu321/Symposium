package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;
import sprite.item.potion.Potion;
import sprite.item.weapon.Fist;
import sprite.item.weapon.Weapon;

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
		for(Item item: this.inventory)
			if(item != null)
				item.setPossessor(this);
		//this.inventory[0] = new Fist();
		currentItemIdx = 0;
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
				newItem.setPossessor(this);
				break;
			}
			currentIndex++;
		}
	}
	
	public Item removeCurrentItem()
	{
		Item remove = inventory[currentItemIdx];
		if(remove == null)
			return null;
		inventory[currentItemIdx].setPossessor(null);
		inventory[currentItemIdx] = null;
		return remove;
	}
	
	public void removeItem(Item item)
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] != null && inventory[i].equals(item))
			{
				inventory[currentItemIdx].setPossessor(null);
				inventory[currentItemIdx] = null;
			}
	}
	
	public boolean isInventoryFull()
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] == null)
				return false;
		return true;
	}
	
	@Override
	public void useCurrentItem(String input) 
	{
		if(getCurrentItem() == null)
			return;
		if(input.equals(Item.POTION)&&inventory[currentItemIdx].getItemType().equals(Item.POTION))
		{
			((Potion) inventory[currentItemIdx]).useItemOnPlayer(this);
		}
		if(input.equals(Item.WEAPON)&&inventory[currentItemIdx].getItemType().equals(Item.WEAPON))
		{
			((Weapon) inventory[currentItemIdx]).useItem();
		}
	}
	
	public void coolDownWeapons(double sec)
	{
		for(Item item : inventory)
			if(item != null && item instanceof Weapon)
				item.coolDownItem(sec);
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
