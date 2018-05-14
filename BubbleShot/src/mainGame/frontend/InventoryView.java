package mainGame.frontend;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
	
	private Canvas avatar;
	
	private FlowPane inventorySlotsContainer;
	private BorderPane inventoryArmorSection;
	
	private Canvas[] inventorySlots;
	
	public InventoryView(Inventory inventory)
	{
		inventoryDis = new VBox(40);
		createArmorSlotSection(inventory);
		createArmorSection();
		inventoryDis.getChildren().addAll(inventoryArmorSection, inventorySlotsContainer);
	}
	
	private void createArmorSlotSection(Inventory inventory)
	{
		inventorySlotsContainer = new FlowPane();
		inventorySlotsContainer.setPrefWidth(650);
		inventorySlotsContainer.setPrefHeight(600);
		inventorySlotsContainer.setVgap(10);
		inventorySlotsContainer.setHgap(10);
		inventorySlots = new Canvas[inventory.getInventory().length];
		for(int i = 0; i < inventorySlots.length; i++)
		{
			inventorySlots[i] = createCanvas();
			inventorySlotsContainer.getChildren().add(inventorySlots[i]);
		}
	}
	
	private void createArmorSection()
	{
		inventoryArmorSection = new BorderPane();
		avatar = new Canvas(100, 100);
		helmetDis = createCanvas();
		BreastPlateDis = createCanvas();
		LeggingDis = createCanvas();
		BootsDis = createCanvas();
		ShieldDis = createCanvas();
		
		VBox leftSide = new VBox(10);
		leftSide.getChildren().addAll(ShieldDis, BootsDis);
		VBox rightSide = new VBox(10);
		rightSide.getChildren().addAll(BreastPlateDis, LeggingDis);
		
		inventoryArmorSection.setTop(helmetDis);
		inventoryArmorSection.setAlignment(helmetDis, Pos.CENTER);
		inventoryArmorSection.setLeft(leftSide);
		inventoryArmorSection.setRight(rightSide);
		inventoryArmorSection.setCenter(avatar);
	}
	
	private Canvas createCanvas()
	{
		Canvas canvas = new Canvas(70, 70);
		canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		return canvas;
	}
	
	public VBox getInventoryDis()
	{
		return inventoryDis;
	}
	
}
