package sprite.character;

import sprite.Sprite;
import sprite.item.Item;

import java.util.ArrayList;
import java.util.List;

import map.Tile.Effects;

public abstract class Character extends Sprite
{
	private int health;
	private int speed;
	private Item selectedItem;
	private List<Effects> activeEffects;
	
	public Character(String fileName, double xLocation, double yLocation, int health, int speed, double width, double height) 
	{
		super(fileName, xLocation, yLocation,width, height);
		activeEffects = new ArrayList<Effects>();
		this.health = health;
		this.speed = speed;
		selectedItem=null;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getSpeed()
	{
		return speed;
	}

	public Item getSelectedItem()
	{
		return selectedItem;
	}
	
	public void setSelectedItem(Item newSelection)
	{
		selectedItem=newSelection;
	}
	
	public void moveUp(double time)
	{
		this.addYLocation(-(speed*time));
	}
	
	public void moveDown(double time)
	{
		this.addYLocation(-(speed*time));
	}
	
	public void moveLeft(double time)
	{
		this.addXLocation(-(speed*time));
	}
	
	public void moveRight(double time)
	{
		this.addXLocation(speed*time);
	}
	
	public abstract void useSelectedItem();
	
}
