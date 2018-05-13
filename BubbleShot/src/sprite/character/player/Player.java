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
	private int currentItemIdx;
	private Item[] inventory = new Item[6];
	private int score;
	private int coins;
	private int currentAmmo;
	private int defaultAmmo;
	private Fist fist = WeaponDesign.getFistDesignOne(this);
	private Helmet helmet;
	private BreastPlate breastPlate;
	private Legging legging;
	private Boots boots;
	private Shield shield;
	
	
	public Player(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double health, double speed, Item[] inventory, int ammoCount) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width,height);
		this.inventory = inventory;
		for(Item item: this.inventory)
			if(item != null)
				item.setPossessor(this);
		currentItemIdx = 0;
		score = 0;
		currentAmmo = ammoCount;
		defaultAmmo = ammoCount;
		coins = 0;
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
	
	public void setCurrentHealth(double health)
	{
		//If the player has no shield or if the player gained health.
		if(shield == null || getCurrentHealth() < health)
		{
			super.setCurrentHealth(health);
			return;
		}
		//if the player has shield and lost health.
		if(shield.isShieldDown())
		{
			super.setCurrentHealth(health);
			return;
		}
		else
		{
			shield.setCurrentShieldAmount(shield.getCurrentShieldAmount() - (getCurrentHealth() - health));
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
		if(getCurrentItem() == null && input.equals(Item.WEAPON))
		{
			fist.useItem();
			return;
		}
		if(input.equals(Item.POTION)&&inventory[currentItemIdx].getItemType().equals(Item.POTION))
		{
			if(inventory[currentItemIdx] instanceof Ammo)
			{
				((Ammo) inventory[currentItemIdx]).useItemOnPlayer(this);
			}
			else
			{
				((Potion) inventory[currentItemIdx]).useItemOnPlayer(this);
			}
		}
		if(input.equals(Item.WEAPON)&&inventory[currentItemIdx].getItemType().equals(Item.WEAPON))
		{
			if(currentAmmo - ((Weapon) inventory[currentItemIdx]).getAmmoUsed() >= 0)
			{
				if(((Weapon) inventory[currentItemIdx]).useItem())
					currentAmmo -= ((Weapon) inventory[currentItemIdx]).getAmmoUsed();
			}
		}
	}
	
	public void coolDownWeapons(double sec)
	{
		for(Item item : inventory)
			if(item != null && item instanceof Weapon)
				item.coolDownItem(sec);
		fist.coolDownItem(sec);
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
	public void setCurrentAmmo(int currentAmmo)
	{
		if(currentAmmo > defaultAmmo)
			this.currentAmmo = defaultAmmo;
		else
		{
			this.currentAmmo = currentAmmo;
		}
	}
	public Item[] getInventory() {return inventory;}
	
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
		this.currentItemIdx = currentItemIdx;
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

	public void setHelmet(Helmet helmet) 
	{
		this.helmet = helmet;
	}

	public void setBreastPlate(BreastPlate breastPlate) 
	{
		this.breastPlate = breastPlate;
	}

	public void setLegging(Legging legging) 
	{
		this.legging = legging;
	}

	public void setBoots(Boots boots) 
	{
		this.boots = boots;
	}

	public void setShield(Shield shield) 
	{
		this.shield = shield;
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
