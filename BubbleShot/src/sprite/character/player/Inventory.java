package sprite.character.player;

import sprite.item.Item;
import sprite.item.armor.Armor;
import sprite.item.armor.Boots;
import sprite.item.armor.BreastPlate;
import sprite.item.armor.Helmet;
import sprite.item.armor.Legging;
import sprite.item.shield.Shield;

public class Inventory
{
	private Item[] inventory;
	private int hotBarSize;
	private int currentItemIdx;
	
	private Helmet helmet;
	private BreastPlate breastPlate;
	private Legging legging;
	private Boots boots;
	private Shield shield;
	
	public Inventory(int inventorySize, int hotBarSize)
	{
		this.hotBarSize = hotBarSize;
		inventory = new Item[inventorySize];
		currentItemIdx = 0;
	}
	
	public Item[] getHotBar()
	{
		Item[] hotBar = new Item[hotBarSize];
		for(int i = 0; i < hotBar.length; i++)
			hotBar[i] = inventory[i];
		return hotBar;
	}

	public Item[] getNonHotBarItems()
	{
		Item[] nonHotBar = new Item[inventory.length - hotBarSize];
		for(int inv = hotBarSize, bar = 0; inv < inventory.length; inv++, bar++)
		{
			nonHotBar[bar] = inventory[inv];
		}
		return nonHotBar;
	}
	
	public boolean addItem(Item newItem)
	{
		int currentIndex = 0;
		while(currentIndex < inventory.length)
		{
			if(inventory[currentIndex] == null)
			{
				inventory[currentIndex] = newItem;
				return true;
			}
			currentIndex++;
		}
		return false;
	}
	
	public Item removeCurrentItem()
	{
		Item remove = inventory[currentItemIdx];
		inventory[currentItemIdx] = null;
		return remove;
	}
	
	public Item getCurrentItem()
	{
		return inventory[currentItemIdx];
	}
	
	public boolean removeItem(Item item)
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] != null && inventory[i].equals(item))
			{
				inventory[currentItemIdx] = null;
				return true;
			}
		return false;
	}
	
	public boolean isInventoryFull()
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] == null)
				return false;
		return true;
	}
	
	public Item setHelmet(Helmet helmet) 
	{
		Helmet temp = this.helmet;
		this.helmet = helmet;
		return temp;
	}

	public Item setBreastPlate(BreastPlate breastPlate) 
	{
		BreastPlate temp = this.breastPlate;
		this.breastPlate = breastPlate;
		return temp;
	}

	public Item setLegging(Legging legging) 
	{
		Legging temp = this.legging;
		this.legging = legging;
		return temp;
	}

	public Item setBoots(Boots boots) 
	{
		Boots temp = this.boots;
		this.boots = boots;
		return temp;
	}

	public Item setShield(Shield shield) 
	{
		Shield temp = this.shield;
		this.shield = shield;
		return temp;
	}

	public Shield getShield()
	{
		return shield;
	}
	
	public Item[] getInventory()
	{
		return inventory;
	}

	public int getCurrentItemIdx()
	{
		return currentItemIdx;
	}

	public void setCurrentItemIdx(int currentItemIdx)
	{
		this.currentItemIdx = currentItemIdx;
	}
	
	
}
