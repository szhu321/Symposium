package sprite.character.player;

import java.io.Serializable;

import sprite.item.Item;
import sprite.item.armor.Armor;
import sprite.item.armor.Boots;
import sprite.item.armor.BreastPlate;
import sprite.item.armor.Helmet;
import sprite.item.armor.Legging;
import sprite.item.shield.Shield;

public class Inventory implements Serializable
{
	private static final long serialVersionUID = -669932254505864887L;
	
	private Item[] inventory;
	private int hotBarSize;
	private int currentItemIdx;
	private Item selectedItem;
	private int selectedItemIdx;

	public static final int HELMET_IDX = -10;
	public static final int BREASTPLATE_IDX = -11;
	public static final int LEGGING_IDX = -12;
	public static final int BOOTS_IDX = -13;
	public static final int SHIELD_IDX = -14;
	
	private Helmet helmet;
	private BreastPlate breastPlate;
	private Legging legging;
	private Boots boots;
	private Shield shield;
	
	private Player possessor;
	
	public Inventory(int inventorySize, int hotBarSize, Player possessor)
	{
		this.hotBarSize = hotBarSize;
		inventory = new Item[inventorySize];
		currentItemIdx = 0;
		this.possessor = possessor;
	}
	
	public void reloadObject()
	{
		if(helmet != null)
			helmet.reloadObject();
		if(breastPlate != null)
			breastPlate.reloadObject();
		if(legging != null)
			legging.reloadObject();
		if(boots != null)
			boots.reloadObject();
		if(shield != null)
			shield.reloadObject();
		if(selectedItem != null)
			selectedItem.reloadObject();
		for(int i = 0; i < inventory.length; i++)
		{
			if(inventory[i] != null)
				inventory[i].reloadObject();
		}
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
	
	public void changeSelectedItem(int idx)
	{
		if(idx < 0)
		{
			changeSelectedArmor(idx);
			return;
		}	
		if(selectedItem != null)
		{
			Item temp = inventory[idx];
			inventory[idx] = selectedItem;
			selectedItem = temp;
			selectedItemIdx = idx;
			return;
		}
		//System.out.println(idx);
		selectedItem = inventory[idx];
		if(selectedItem == null)
			return;
		inventory[idx] = null;
		selectedItemIdx = idx;
	}
	
	private void swapArmor(int idx)
	{
		Item temp = null;
		if(idx == Inventory.HELMET_IDX)
		{
			temp = helmet;
			helmet = (Helmet)selectedItem;
			selectedItemIdx = Inventory.HELMET_IDX;
		}
		if(idx == Inventory.BREASTPLATE_IDX)
		{
			temp = breastPlate;
			breastPlate = (BreastPlate)selectedItem;
			selectedItemIdx = Inventory.BREASTPLATE_IDX;
		}
		if(idx == Inventory.LEGGING_IDX)
		{
			temp = legging;
			legging = (Legging)selectedItem;
			selectedItemIdx = Inventory.LEGGING_IDX;
		}
		if(idx == Inventory.BOOTS_IDX)
		{
			temp = boots;
			boots = (Boots)selectedItem;
			selectedItemIdx = Inventory.BOOTS_IDX;
		}
		if(idx == Inventory.SHIELD_IDX)
		{
			temp = shield;
			shield = (Shield)selectedItem;
			selectedItemIdx = Inventory.SHIELD_IDX;
		}
		selectedItem = temp;
	}
	
	public void changeSelectedArmor(int idx)
	{
		if(selectedItem != null)
		{
			//Checks to see if the swap is legal.
			if(selectedItem instanceof Helmet && idx == Inventory.HELMET_IDX)
				swapArmor(idx);
			else if(selectedItem instanceof Legging && idx == Inventory.LEGGING_IDX)
				swapArmor(idx);
			else if(selectedItem instanceof BreastPlate && idx == Inventory.BREASTPLATE_IDX)
				swapArmor(idx);
			else if(selectedItem instanceof Boots && idx == Inventory.BOOTS_IDX)
				swapArmor(idx);
			else if(selectedItem instanceof Shield && idx == Inventory.SHIELD_IDX)
				swapArmor(idx);
		}
		else
			swapArmor(idx);
	}
	
	public void returnSelectedItem()
	{
		if(selectedItem == null)
			return;
		if(selectedItemIdx < 0)
			returnSelectedArmor();
		inventory[selectedItemIdx] = selectedItem;
		selectedItem = null;
	}
	
	public void returnSelectedArmor()
	{
		if(selectedItem == null)
			return;
		if(selectedItemIdx == Inventory.BOOTS_IDX)
			boots = (Boots)selectedItem;
		if(selectedItemIdx == Inventory.HELMET_IDX)
			helmet = (Helmet)selectedItem;
		if(selectedItemIdx == Inventory.BREASTPLATE_IDX)
			breastPlate = (BreastPlate)selectedItem;
		if(selectedItemIdx == Inventory.LEGGING_IDX)
			legging = (Legging)selectedItem;
		if(selectedItemIdx == Inventory.SHIELD_IDX)
			shield = (Shield)selectedItem;
		selectedItem = null;
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
	
	public Item removeSelectedItem()
	{
		Item remove = selectedItem;
		selectedItem = null;
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
	
	public double getMaxHealthBoost()
	{
		double result = 0;
		if(helmet != null)
			result += helmet.getMaxHealthBoost();
		if(legging != null)
			result += legging.getMaxHealthBoost();
		if(breastPlate != null)
			result += breastPlate.getMaxHealthBoost();
		if(boots != null)
			result += boots.getMaxHealthBoost();
		return result;
	}
	
	public double getMaxSpeedBoost()
	{
		double result = 1;
		if(helmet != null)
			result *= helmet.getMaxSpeedBoost();
		if(legging != null)
			result *= legging.getMaxSpeedBoost();
		if(breastPlate != null)
			result *= breastPlate.getMaxSpeedBoost();
		if(boots != null)
			result *= boots.getMaxSpeedBoost();
		return result;
	}
	
	public double getMaxDamageBoost()
	{
		double result = 1;
		if(helmet != null)
			result *= helmet.getMaxDamageBoost();
		if(legging != null)
			result *= legging.getMaxDamageBoost();
		if(breastPlate != null)
			result *= breastPlate.getMaxDamageBoost();
		if(boots != null)
			result *= boots.getMaxDamageBoost();
		return result;
	}
	
	public Helmet getHelmet() 
	{
		return helmet;
	}

	public BreastPlate getBreastPlate() 
	{
		return breastPlate;
	}

	public Legging getLegging()
	{
		return legging;
	}

	public Boots getBoots()
	{
		return boots;
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
	
	public Item getSelectedItem()
	{
		return selectedItem;
	}
	
	public Player getPossessor()
	{
		return possessor;
	}
}
