package mainGame.frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sprite.character.player.Inventory;
import sprite.item.Item;

public class InventoryView 
{
	private VBox inventoryDis;
	
	private Canvas helmetDis;
	private Canvas BreastPlateDis;
	private Canvas LeggingDis;
	private Canvas BootsDis;
	private Canvas ShieldDis;
	
	private Canvas avatar;
	
	private VBox inventorySlotsContainer;
	private BorderPane inventoryArmorSection;
	
	private Canvas[] inventorySlotsTop;
	private Canvas[] inventorySlotsHotBar;
	
	private int slotCounter;
	
	public InventoryView(Inventory inventory)
	{
		inventoryDis = new VBox(40);
		inventoryDis.setMaxHeight(500);
		inventoryDis.setPadding(new Insets(20, 20 ,20 ,20));
		createSlotSection(inventory);
		createArmorSection();
		inventoryDis.setAlignment(Pos.CENTER);
		inventoryDis.getChildren().addAll(inventoryArmorSection, inventorySlotsContainer);
	}
	
	private void createSlotSection(Inventory inventory)
	{
		inventorySlotsContainer = new VBox(30);
		inventorySlotsContainer.setPrefWidth(650);
		
		slotCounter = 0;
		
		FlowPane hotBarDis = new FlowPane();
		hotBarDis.setPrefWidth(650);
		hotBarDis.setVgap(20);
		hotBarDis.setHgap(20);
		inventorySlotsHotBar = new Canvas[inventory.getHotBar().length];
		//System.out.println(inventory.getHotBar().length);
		for(int i = 0; i < inventorySlotsHotBar.length; i++)
		{
			inventorySlotsHotBar[i] = createCanvas();
			hotBarDis.getChildren().add(inventorySlotsHotBar[i]);
		}
		inventorySlotsHotBar[0].setOnMousePressed(event -> {inventory.changeSelectedItem(0);});
		inventorySlotsHotBar[1].setOnMousePressed(event -> {inventory.changeSelectedItem(1);});
		inventorySlotsHotBar[2].setOnMousePressed(event -> {inventory.changeSelectedItem(2);});
		inventorySlotsHotBar[3].setOnMousePressed(event -> {inventory.changeSelectedItem(3);});
		inventorySlotsHotBar[4].setOnMousePressed(event -> {inventory.changeSelectedItem(4);});
		inventorySlotsHotBar[5].setOnMousePressed(event -> {inventory.changeSelectedItem(5);});
		
		FlowPane nonHotBarDis = new FlowPane();
		nonHotBarDis.setPrefWidth(650);
		nonHotBarDis.setVgap(20);
		nonHotBarDis.setHgap(20);
		inventorySlotsTop = new Canvas[inventory.getNonHotBarItems().length];
		//System.out.println(inventory.getNonHotBarItems().length);
		for(int i = 0; i < inventorySlotsTop.length; i++)
		{
			inventorySlotsTop[i] = createCanvas();
			nonHotBarDis.getChildren().add(inventorySlotsTop[i]);
		}
		inventorySlotsTop[0].setOnMousePressed(event -> {inventory.changeSelectedItem(6);});
		inventorySlotsTop[1].setOnMousePressed(event -> {inventory.changeSelectedItem(7);});
		inventorySlotsTop[2].setOnMousePressed(event -> {inventory.changeSelectedItem(8);});
		inventorySlotsTop[3].setOnMousePressed(event -> {inventory.changeSelectedItem(9);});
		
		inventorySlotsContainer.getChildren().addAll(nonHotBarDis, hotBarDis);
	}
	
	public void updateInventoryDis(Inventory inventory)
	{
		Item[] invItems = inventory.getNonHotBarItems();
		Item[] invHotBar = inventory.getHotBar();
		
		for(int i = 0; i < invItems.length; i++)
		{
			inventorySlotsTop[i].getGraphicsContext2D().fillRect(0, 0, inventorySlotsTop[i].getWidth(), inventorySlotsTop[i].getHeight());
			if(invItems[i] != null)
				inventorySlotsTop[i].getGraphicsContext2D().drawImage(invItems[i].getSpriteImage(), 0, 0, 50, 50);
		}
		
		for(int i = 0; i < invHotBar.length; i++)
		{
			inventorySlotsHotBar[i].getGraphicsContext2D().fillRect(0, 0, inventorySlotsHotBar[i].getWidth(), inventorySlotsHotBar[i].getHeight());
			if(invHotBar[i] != null)
				inventorySlotsHotBar[i].getGraphicsContext2D().drawImage(invHotBar[i].getSpriteImage(), 0, 0, 50, 50);
		}
	}
	
	private void createArmorSection()
	{
		inventoryArmorSection = new BorderPane();
		inventoryArmorSection.setMaxWidth(200);
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
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.LIGHTGRAY);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		return canvas;
	}
	
	public VBox getInventoryDis()
	{
		return inventoryDis;
	}
	
}
