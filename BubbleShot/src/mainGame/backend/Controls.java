package mainGame.backend;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class Controls
{
	private String up;
	private String down;
	private String left;
	private String right;
	private String inventory;
	private String buyItem;
	private String pause;
	private String dropItem;
	private String sprint;
	private String shoot;
	private String useItem;
	
	public Controls()
	{
		resetControls();
	}
	
	public void resetControls()
	{
		up = KeyCode.W.toString();
		down = KeyCode.S.toString();
		left = KeyCode.A.toString();
		right = KeyCode.D.toString();
		inventory = KeyCode.E.toString();
		pause = KeyCode.P.toString();
		buyItem = KeyCode.Q.toString();
		dropItem = KeyCode.G.toString();
		sprint = KeyCode.SHIFT.toString();
		shoot = MouseButton.PRIMARY.toString();
		useItem = MouseButton.SECONDARY.toString();
	}

	public String getUp()
	{
		return up;
	}

	public String getDown()
	{
		return down;
	}

	public String getLeft()
	{
		return left;
	}

	public String getRight()
	{
		return right;
	}

	public String getInventory() 
	{
		return inventory;
	}

	public String getBuyItem() 
	{
		return buyItem;
	}

	public String getPause()
	{
		return pause;
	}

	public String getDropItem()
	{
		return dropItem;
	}

	public String getSprint()
	{
		return sprint;
	}

	public String getShoot() 
	{
		return shoot;
	}

	public String getUseItem() 
	{
		return useItem;
	}

	public void setUp(String up)
	{
		this.up = up;
	}

	public void setDown(String down) 
	{
		this.down = down;
	}

	public void setLeft(String left)
	{
		this.left = left;
	}

	public void setRight(String right)
	{
		this.right = right;
	}

	public void setInventory(String inventory) 
	{
		this.inventory = inventory;
	}

	public void setBuyItem(String buyItem) 
	{
		this.buyItem = buyItem;
	}

	public void setPause(String pause)
	{
		this.pause = pause;
	}

	public void setDropItem(String dropItem) 
	{
		this.dropItem = dropItem;
	}

	public void setSprint(String sprint)
	{
		this.sprint = sprint;
	}

	public void setShoot(String shoot)
	{
		this.shoot = shoot;
	}

	public void setUseItem(String useItem)
	{
		this.useItem = useItem;
	}
	
	
}
