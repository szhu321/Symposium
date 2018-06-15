package mainGame.backend;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import myutilities.ControlItem;

public class Controls
{
	//Movement Controls
	private ControlItem up;
	private ControlItem down;
	private ControlItem left;
	private ControlItem right;
	private ControlItem sprint;
	
	//Hotbar Controls
	private ControlItem hotBar1;
	private ControlItem hotBar2;
	private ControlItem hotBar3;
	private ControlItem hotBar4;
	private ControlItem hotBar5;
	private ControlItem hotBar6;
	
	//Action Controls
	private ControlItem inventory;
	private ControlItem buyItem;
	private ControlItem dropItem;
	private ControlItem shoot;
	private ControlItem useItem;
	
	//Other Controls
	private ControlItem pause;
	private ControlItem fullScreen;
	
	//The list of controlItems
	private List<ControlItem> controlItems;
	
	public Controls()
	{
		resetControls();
		fillUpControlItemList();
	}
	
	private void fillUpControlItemList()
	{
		controlItems = new ArrayList<ControlItem>();
		controlItems.add(up);
		controlItems.add(down);
		controlItems.add(left);
		controlItems.add(right);
		controlItems.add(sprint);
		controlItems.add(hotBar1);
		controlItems.add(hotBar2);
		controlItems.add(hotBar3);
		controlItems.add(hotBar4);
		controlItems.add(hotBar5);
		controlItems.add(hotBar6);
		controlItems.add(inventory);
		controlItems.add(buyItem);
		controlItems.add(dropItem);
		controlItems.add(shoot);
		controlItems.add(useItem);
		controlItems.add(pause);
		controlItems.add(fullScreen);
	}

	public void resetControls()
	{
		up = new ControlItem("Move Up", KeyCode.W.toString());
		down = new ControlItem("Move Down", KeyCode.S.toString());
		left = new ControlItem("Move Left", KeyCode.A.toString());
		right = new ControlItem("Move Right", KeyCode.D.toString());
		inventory = new ControlItem("Open Inventory", KeyCode.E.toString());
		pause = new ControlItem("Pause Game", KeyCode.P.toString());
		buyItem = new ControlItem("Buy Item", KeyCode.Q.toString());
		dropItem = new ControlItem("Drop Item", KeyCode.G.toString());
		sprint = new ControlItem("Sprint", KeyCode.SHIFT.toString());
		shoot = new ControlItem("Shoot", MouseButton.PRIMARY.toString());
		useItem = new ControlItem("Use Item", MouseButton.SECONDARY.toString());
		fullScreen = new ControlItem("Toggle Fullscreen", KeyCode.F11.toString());
		hotBar1 = new ControlItem("Hot Key 1", KeyCode.DIGIT1.toString());
		hotBar2 = new ControlItem("Hot Key 2", KeyCode.DIGIT2.toString());
		hotBar3 = new ControlItem("Hot Key 3", KeyCode.DIGIT3.toString());
		hotBar4 = new ControlItem("Hot Key 4", KeyCode.DIGIT4.toString());
		hotBar5 = new ControlItem("Hot Key 5", KeyCode.DIGIT5.toString());
		hotBar6 = new ControlItem("Hot Key 6", KeyCode.DIGIT6.toString());
	}

	/* Getters*/
	public ControlItem getUp(){return up;}
	public ControlItem getDown(){return down;}
	public ControlItem getLeft(){return left;}
	public ControlItem getRight(){return right;}
	public ControlItem getSprint() {return sprint;}
	public ControlItem getHotBar1(){return hotBar1;}
	public ControlItem getHotBar2(){return hotBar2;}
	public ControlItem getHotBar3(){return hotBar3;}
	public ControlItem getHotBar4(){return hotBar4;}
	public ControlItem getHotBar5() {return hotBar5;}
	public ControlItem getHotBar6() {return hotBar6;}
	public ControlItem getInventory(){return inventory;}
	public ControlItem getBuyItem(){return buyItem;}
	public ControlItem getDropItem(){return dropItem;}
	public ControlItem getShoot() {return shoot;}
	public ControlItem getUseItem() {return useItem;}
	public ControlItem getPause(){return pause;}
	public ControlItem getFullScreen(){return fullScreen;}
	public List<ControlItem> getControlItems(){return controlItems;}
	
	

}
