package mainGame.frontend;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sprite.character.player.Inventory;

public class InventoryView 
{
	private VBox inventoryDis;
	
	private Canvas helmetDis;
	private Canvas BreastPlateDis;
	private Canvas LeggingDis;
	private Canvas BootsDis;
	private Canvas ShieldDis;
	
	private Group inventorySlotsContainer;
	private Canvas[] inventorySlots;
	
	public InventoryView(Inventory inventory)
	{
		createCanvas(helmetDis);
		createCanvas(BreastPlateDis);
		createCanvas(LeggingDis);
		createCanvas(BootsDis);
		createCanvas(ShieldDis);
		inventorySlots = new Canvas[inventory.getInventory().length];
	}
	
	private void createCanvas(Canvas canvas)
	{
		canvas = new Canvas(70, 70);
	}
	
	public VBox getInventoryDis()
	{
		return inventoryDis;
	}
	
}
