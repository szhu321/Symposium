package mainGame.backend;

import java.util.ArrayList;
import java.util.List;

import myutilities.GraphicsItem;

public class Graphics
{
	public GraphicsItem displayCharacterNames;
	public GraphicsItem displayItemNames;
	public GraphicsItem displayCharacterShadow;
	public GraphicsItem displayItemShadow;
	public GraphicsItem displayObstacleShadow;
	public GraphicsItem displayItemRotating;
	public GraphicsItem displayCharacterEffects;
	public GraphicsItem displayShadowMode;
	public GraphicsItem displayBlindMode;
	
	List<GraphicsItem> graphicsItems;
	
	public Graphics()
	{
		resetGraphics();
		fillUpGraphicsItemList();
	}
	
	public void fillUpGraphicsItemList()
	{
		graphicsItems = new ArrayList<GraphicsItem>();
		graphicsItems.add(displayCharacterNames);
		graphicsItems.add(displayItemNames);
		graphicsItems.add(displayCharacterShadow);
		graphicsItems.add(displayItemShadow);
		graphicsItems.add(displayObstacleShadow);
		graphicsItems.add(displayItemRotating);
		graphicsItems.add(displayCharacterEffects);
		graphicsItems.add(displayShadowMode);
		graphicsItems.add(displayBlindMode);
		
	}
	
	public void resetGraphics()
	{
		displayCharacterNames = new GraphicsItem("Display Character Names", false);
		displayItemNames = new GraphicsItem("Display Item Names", false);
		displayCharacterShadow = new GraphicsItem("Display Character Shadow", true);
		displayItemShadow = new GraphicsItem("Display Item Shadow", true);
		displayObstacleShadow = new GraphicsItem("Display Obstacle Shadow", true);
		displayItemRotating = new GraphicsItem("Display Item Roatating", true);
		displayCharacterEffects = new GraphicsItem("Display Character Effects", true);
		displayShadowMode = new GraphicsItem("Display Shadow Mode", true);
		displayBlindMode = new GraphicsItem("Display Blind Mode", false);
	}

	/*Getters*/
	public GraphicsItem getDisplayCharacterNames() {return displayCharacterNames;}
	public GraphicsItem getDisplayItemNames() {return displayItemNames;}
	public GraphicsItem getDisplayCharacterShadow() {return displayCharacterShadow;}
	public GraphicsItem getDisplayItemShadow() {return displayItemShadow;}
	public GraphicsItem getDisplayObstacleShadow() {return displayObstacleShadow;}
	public GraphicsItem getDisplayItemRotating() {return displayItemRotating;}
	public GraphicsItem getDisplayCharacterEffects() {return displayCharacterEffects;}
	public GraphicsItem getDisplayShadowMode() {return displayShadowMode;}
	public GraphicsItem getDisplayBlindMode() {return displayBlindMode;}
	public List<GraphicsItem> getGraphicsItems() {return graphicsItems;}

}
