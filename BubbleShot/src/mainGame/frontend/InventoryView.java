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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import sprite.character.player.Inventory;
import sprite.item.Item;

public class InventoryView 
{
	private VBox inventoryDis;
	
	private Canvas helmetDis;
	private Canvas breastPlateDis;
	private Canvas leggingDis;
	private Canvas bootsDis;
	private Canvas shieldDis;
	
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
		createArmorSection(inventory);
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
		//Draw armor
		if(inventory.getHelmet() != null)
			helmetDis.getGraphicsContext2D().drawImage(inventory.getHelmet().getSpriteImage(), 0, 0, 50, 50);
		else
		{
			helmetDis.getGraphicsContext2D().fillRect(0, 0, helmetDis.getWidth(), helmetDis.getHeight());
			fillText(helmetDis.getGraphicsContext2D(), Color.BLACK, "helmet", 20);
		}
		
		if(inventory.getBreastPlate() != null)
			breastPlateDis.getGraphicsContext2D().drawImage(inventory.getBreastPlate().getSpriteImage(), 0, 0, 50, 50);
		else
		{
			breastPlateDis.getGraphicsContext2D().fillRect(0, 0, breastPlateDis.getWidth(), breastPlateDis.getHeight());
			fillText(breastPlateDis.getGraphicsContext2D(), Color.BLACK, "breast \nplate", 20);
		}
		
		if(inventory.getLegging() != null)
			leggingDis.getGraphicsContext2D().drawImage(inventory.getLegging().getSpriteImage(), 0, 0, 50, 50);
		else
		{
			leggingDis.getGraphicsContext2D().fillRect(0, 0, leggingDis.getWidth(), leggingDis.getHeight());
			fillText(leggingDis.getGraphicsContext2D(), Color.BLACK, "legging", 20);
		}
		
		if(inventory.getBoots() != null)
			bootsDis.getGraphicsContext2D().drawImage(inventory.getBoots().getSpriteImage(), 0, 0, 50, 50);
		else
		{
			bootsDis.getGraphicsContext2D().fillRect(0, 0, bootsDis.getWidth(), bootsDis.getHeight());
			fillText(bootsDis.getGraphicsContext2D(), Color.BLACK, "boots", 20);
		}
		
		if(inventory.getShield() != null)
			shieldDis.getGraphicsContext2D().drawImage(inventory.getShield().getSpriteImage(), 0, 0, 50, 50);
		else
		{
			shieldDis.getGraphicsContext2D().fillRect(0, 0, shieldDis.getWidth(), shieldDis.getHeight());
			fillText(shieldDis.getGraphicsContext2D(), Color.BLACK, "shield", 20);
		}
	}
	
	private void fillText(GraphicsContext gc, Paint color, String text, int font)
	{
		gc.save();
		gc.setFill(color);
		gc.setFont(new Font(font));
		gc.fillText(text, 2, gc.getCanvas().getHeight() / 2);
		gc.restore();
	}
	
	private void createArmorSection(Inventory inventory)
	{
		inventoryArmorSection = new BorderPane();
		inventoryArmorSection.setMaxWidth(200);
		avatar = new Canvas(100, 100);
		helmetDis = createCanvas();
		breastPlateDis = createCanvas();
		leggingDis = createCanvas();
		bootsDis = createCanvas();
		shieldDis = createCanvas();
		
		helmetDis.setOnMousePressed(event -> {inventory.changeSelectedItem(Inventory.HELMET_IDX);});
		breastPlateDis.setOnMousePressed(event -> {inventory.changeSelectedItem(Inventory.BREASTPLATE_IDX);});
		leggingDis.setOnMousePressed(event -> {inventory.changeSelectedItem(Inventory.LEGGING_IDX);});
		bootsDis.setOnMousePressed(event -> {inventory.changeSelectedItem(Inventory.BOOTS_IDX);});
		shieldDis.setOnMousePressed(event -> {inventory.changeSelectedItem(Inventory.SHIELD_IDX);});
		
		VBox leftSide = new VBox(10);
		leftSide.getChildren().addAll(shieldDis, bootsDis);
		VBox rightSide = new VBox(10);
		rightSide.getChildren().addAll(breastPlateDis, leggingDis);
		
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
