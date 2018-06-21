package sprite.character.player;

import java.util.Date;

import mainGame.GameRunner;
import map.Level;
import sprite.character.Character;
import sprite.item.Item;
import sprite.item.ammo.Ammo;
import sprite.item.collectable.InstantCollect;
import sprite.item.potion.Potion;
import sprite.item.weapon.Fist;
import sprite.item.weapon.Weapon;
import sprite.item.weapon.WeaponDesign;

public class Player extends Character
{
	private static final long serialVersionUID = 6250201579574452541L;
	
	private String spriteName;
	private Inventory inventory;
	
	private int currentItemIdx;
	//private Item[] inventory = new Item[6];
	//private int score;
	private int coins;
	private int currentAmmo;
	private int defaultAmmo;
	private static int currentLevel;
	private int localLevel;
	private Fist fist = WeaponDesign.getFistDesignOne(this);
	private Date date;
	
	
	public Player(String spriteName, String fileName, double xLocation, double yLocation, double width, double height, double health, double speed, int ammoCount) 
	{
		super(spriteName,fileName, xLocation, yLocation, health, speed, width,height);
		inventory = new Inventory(10, 6 , this);
		currentItemIdx = 0;
		currentAmmo = ammoCount;
		defaultAmmo = ammoCount;
		coins = 2000;
		localLevel = 1;
		currentLevel = localLevel;
	}
	
	public void reloadObject()
	{
		super.reloadObject();
		fist.reloadObject();
		inventory.reloadObject();
		currentLevel = localLevel;
	}
	
	public void addItem(Item newItem)
	{
		if(newItem instanceof InstantCollect)
		{
			((InstantCollect) newItem).collect(this);
			return;
		}
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
	
	public void addCoins(int num)
	{
		coins+=num;
	}
	
	public void removeItem(Item item)
	{
		if(inventory.removeItem(item))
			item.setPossessor(null);
	}
	
	public void setCurrentHealth(double health)
	{
		//adjusted Health loss because of armor points
		//System.out.println(health + "old");
		if(getCurrentHealth() > health)
		{
			health = getCurrentHealth() - ((getCurrentHealth() - health) * inventory.getDamageReducer());
		}
		//System.out.println(health + "new");
		
		//If the player has no shield or if the player gained health.
		if(inventory.getShield() == null || getCurrentHealth() < health)
		{
			if(health > getDefaultHealth())
				super.setCurrentHealth(getDefaultHealth());
			else
				super.setCurrentHealth(health);
			return;
		}
		//if the player has shield and lost health.
		if(inventory.getShield().isShieldDown())
		{
			if(health > getDefaultHealth())
				super.setCurrentHealth(getDefaultHealth());
			else
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
		//System.out.println(getCurrentItem());
		if(getCurrentItem() == null && input.equals(Item.WEAPON))
		{
			
			fist.useItem();
			return;
		}
		if(input.equals(Item.POTION)&&inventory.getCurrentItem().getItemType().equals(Item.POTION))
		{
			//System.out.println("What");
			if(inventory.getCurrentItem() instanceof Ammo)
			{
				((Ammo) inventory.getCurrentItem()).useItemOnPlayer(this);
			}
			else
			{
				((Potion) inventory.getCurrentItem()).useItemOnPlayer(this);
				//System.out.println("hint");
			}
		}
		if(input.equals(Item.WEAPON)&&inventory.getCurrentItem().getItemType().equals(Item.WEAPON))
		{
			if(((Weapon) inventory.getCurrentItem()).isAutomatic() || (!((Weapon) inventory.getCurrentItem()).isAutomatic() && GameRunner.getGameManager().isClick()))
			{
				if(currentAmmo - ((Weapon) inventory.getCurrentItem()).getAmmoUsed() >= 0)
				{
					if(((Weapon) inventory.getCurrentItem()).useItem())
						currentAmmo -= ((Weapon) inventory.getCurrentItem()).getAmmoUsed();
				}
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
	
	public double getSpeed()
	{
		return super.getSpeed() * inventory.getMaxSpeedBoost();
	}
	
	public double getDamageBoost()
	{
		return inventory.getMaxDamageBoost();
	}
	
	public double getDefaultHealth()
	{
		return super.getDefaultHealth() + inventory.getMaxHealthBoost();
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

	public static int getCurrentLevel()
	{
		return currentLevel;
	}

	public static void setCurrentLevel(int currentLevel)
	{
		Player.currentLevel = currentLevel;
	}

	public int getLocalLevel()
	{
		return localLevel;
	}

	public void setLocalLevel(int localLevel)
	{
		this.localLevel = localLevel;
		Player.setCurrentLevel(localLevel);
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
