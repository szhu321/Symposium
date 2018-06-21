package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import mainGame.GameRunner;
import mainGame.backend.Graphics;
import myutilities.ControlItem;
import myutilities.GraphicsItem;
import sound.SoundEffects;

public class GraphicsViewController implements Initializable
{
	public BorderPane container;
	
	public ScrollPane graphicsContainer;
	public GridPane graphicsItemGrid;
	
	private Graphics graphics;
	private List<CheckBox> boxHolder;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		container.setId("borderPaneContainer");
		graphicsItemGrid.setPrefWidth(GameRunner.getResolutionWidth() - 50);
		graphicsContainer.setPrefHeight(GameRunner.getResolutionHeight() - 100);
		graphics = GameRunner.getGraphics();
		loadGraphicsItemGrid();
	}
	
	private void loadGraphicsItemGrid()
	{
		List<GraphicsItem> items = graphics.getGraphicsItems();
		boxHolder = new ArrayList<CheckBox>();
		for(int i = 0; i < items.size(); i++)
		{
			GraphicsItem currentItem = items.get(i);
			currentItem.setId(i);
			Label text = new Label(currentItem.getGraphicsName());
			
			CheckBox inputBox = new CheckBox("");
			inputBox.setSelected(currentItem.getCurrentValue());
			inputBox.setOnAction(event -> changeValue(inputBox, currentItem.getId()));
			
			boxHolder.add(inputBox);
			graphicsItemGrid.add(text, 1, i);
			graphicsItemGrid.add(inputBox, 2, i);
		}
	}
	
	public void changeValue(CheckBox box, int id)
	{
		GraphicsItem graphicsItem = graphics.getGraphicsItems().get(id);
		graphicsItem.setCurrentValue(box.isSelected());
	}
	
	public void resetBtnOnclick()
	{
		
	}
	
	public void backBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToSettingsView();
	}

}
