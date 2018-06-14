package mainGame.backend;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class Controls
{
	//Movement Controls
	private String up;
	private String down;
	private String left;
	private String right;
	private String sprint;
	
	//Hotbar Controls
	private String hotBar1;
	private String hotBar2;
	private String hotBar3;
	private String hotBar4;
	private String hotBar5;
	private String hotBar6;
	
	//Action Controls
	private String inventory;
	private String buyItem;
	private String dropItem;
	private String shoot;
	private String useItem;
	
	//Other Controls
	private String pause;
	private String fullScreen;
	
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
		fullScreen = KeyCode.F11.toString();
		hotBar1 = KeyCode.DIGIT1.toString();
		hotBar2 = KeyCode.DIGIT2.toString();
		hotBar3 = KeyCode.DIGIT3.toString();
		hotBar4 = KeyCode.DIGIT4.toString();
		hotBar5 = KeyCode.DIGIT5.toString();
		hotBar6 = KeyCode.DIGIT6.toString();
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

	public String getHotBar1() 
	{
		return hotBar1;
	}

	public String getHotBar2()
	{
		return hotBar2;
	}

	public String getHotBar3()
	{
		return hotBar3;
	}

	public String getHotBar4() 
	{
		return hotBar4;
	}

	public String getHotBar5() 
	{
		return hotBar5;
	}

	public String getHotBar6() 
	{
		return hotBar6;
	}

	public String getFullScreen()
	{
		return fullScreen;
	}

	public void setHotBar1(String hotBar1)
	{
		this.hotBar1 = hotBar1;
	}

	public void setHotBar2(String hotBar2) 
	{
		this.hotBar2 = hotBar2;
	}

	public void setHotBar3(String hotBar3)
	{
		this.hotBar3 = hotBar3;
	}

	public void setHotBar4(String hotBar4) 
	{
		this.hotBar4 = hotBar4;
	}

	public void setHotBar5(String hotBar5) 
	{
		this.hotBar5 = hotBar5;
	}

	public void setHotBar6(String hotBar6) 
	{
		this.hotBar6 = hotBar6;
	}

	public void setFullScreen(String fullScreen) 
	{
		this.fullScreen = fullScreen;
	}
	
	
	
}
