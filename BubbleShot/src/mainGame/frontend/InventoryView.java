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
		
		inventorySlotsContainer.getChildren().addAll(nonHotBarDis, hotBarDis);
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
