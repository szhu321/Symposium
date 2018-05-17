package sprite.character.player;

import sprite.character.Character;
import sprite.item.Item;
import sprite.item.ammo.Ammo;
import sprite.item.armor.Boots;
import sprite.item.armor.BreastPlate;
import sprite.item.armor.Helmet;
import sprite.item.armor.Legging;
import sprite.item.potion.Potion;
import sprite.item.shield.Shield;
import sprite.item.weapon.Fist;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class Player extends Character
{
	
	private String spriteName;
	private Inventory inventory;
	
	private int currentItemIdx;
	//private Item[] inventory = new Item[6];
	//private int score;
	private int coins;
	private int currentAmmo;
	private int defaultAmmo;
	private Fist fist = WeaponDesign.getFistDesignOne(this);
	
	
	public Player(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double health, double speed, int ammoCount) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width,height);
		inventory = new Inventory(10, 6);
		currentItemIdx = 0;
		currentAmmo = ammoCount;
		defaultAmmo = ammoCount;
		coins = 0;
	}
	
	public void addItem(Item newItem)
	{
		if(inventory.addItem(newItem))
			newItem.setPossessor(this);
	}
	
	public Item removeCurrentItem()
	{
		Item remove = inventory.removeCurrentItem();
		if(remove == null)
			return null;
		remove.setPossessor(null);
		return remove;
	}
	
	public void removeItem(Item item)
	{
		if(inventory.removeItem(item))
			item.setPossessor(null);
	}
	
	public void setCurrentHealth(double health)
	{
		//If the player has no shield or if the player gained health.
		if(inventory.getShield() == null || getCurrentHealth() < health)
		{
			super.setCurrentHealth(health);
			return;
		}
		//if the player has shield and lost health.
		if(inventory.getShield().isShieldDown())
		{
			super.setCurrentHealth(health);
			return;
		}
		else
		{
			inventory.getShield().setCurrentShieldAmount(inventory.getShield().getCurrentShieldAmount() - (getCurrentHealth() - health));
		}
	}
	
	public boolean isInventoryFull()
	{
		return inventory.isInventoryFull();
	}
	
	@Override
	public void useCurrentItem(String input) 
	{
		if(getCurrentItem() == null && input.equals(Item.WEAPON))
		{
			fist.useItem();
			return;
		}
		if(input.equals(Item.POTION)&&inventory.getCurrentItem().getItemType().equals(Item.POTION))
		{
			if(inventory.getCurrentItem() instanceof Ammo)
			{
				((Ammo) inventory.getCurrentItem()).useItemOnPlayer(this);
			}
			else
			{
				((Potion) inventory.getCurrentItem()).useItemOnPlayer(this);
			}
		}
		if(input.equals(Item.WEAPON)&&inventory.getCurrentItem().getItemType().equals(Item.WEAPON))
		{
			if(currentAmmo - ((Weapon) inventory.getCurrentItem()).getAmmoUsed() >= 0)
			{
				if(((Weapon) inventory.getCurrentItem()).useItem())
					currentAmmo -= ((Weapon) inventory.getCurrentItem()).getAmmoUsed();
			}
		}
	}
	
	public void coolDownWeapons(double sec)
	{
		for(Item item : inventory.getInventory())
			if(item != null && item instanceof Weapon)
				((Weapon)item).coolDownItem(sec);
		((Weapon)fist).coolDownItem(sec);
	}
	
	public void selectItem(String input)
	{
		currentItemIdx = Integer.parseInt(input);
	}
	
	public int getCurrentItemIdx()
	{
		return inventory.getCurrentItemIdx();
	}
	
	public Item getCurrentItem()
	{
		return inventory.getCurrentItem();
	}
	
	public int getCurrentAmmo() {return currentAmmo;}
	public int getDefaultAmmo() {return defaultAmmo;}
	public void setCurrentAmmo(int currentAmmo)
	{
		if(currentAmmo > defaultAmmo)
			this.currentAmmo = defaultAmmo;
		else
		{
			this.currentAmmo = currentAmmo;
		}
	}
	public Item[] getHotBar() {return inventory.getHotBar();}
	
	public Inventory getInventory() 
	{
		return inventory;
	}
	
	public int getCoins() 
	{
		return coins;
	}

	public void setCoins(int coins) 
	{
		this.coins = coins;
	}

	public void setCurrentItemIdx(int currentItemIdx)
	{
		inventory.setCurrentItemIdx(currentItemIdx);
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
