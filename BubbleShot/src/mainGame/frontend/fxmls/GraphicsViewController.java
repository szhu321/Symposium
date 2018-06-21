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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mainGame.GameRunner;
import mainGame.backend.Graphics;
import myutilities.ControlItem;
import myutilities.GraphicsItem;
import sound.SoundEffects;

public class GraphicsViewController implements Initializable
{
	public BorderPane container;
	
	public ScrollPane graphicsContainer;
	public GridPane graphicsItemBox;
	
	private Graphics graphics;
	private List<CheckBox> boxHolder;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		container.setId("borderPaneContainer");
		graphicsItemBox.setPrefWidth(GameRunner.getResolutionWidth() - 300);
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
			//HBox hb = new HBox(30);
			//hb.getChildren().addAll(text, inputBox);
			graphicsItemBox.add(text, 1, i);
			graphicsItemBox.add(inputBox, 2, i);
		}
	}
	
	public void changeValue(CheckBox box, int id)
	{
		GraphicsItem graphicsItem = graphics.getGraphicsItems().get(id);
		graphicsItem.setCurrentValue(box.isSelected());
	}
	
	public void resetBtnOnclick()
	{
		graphics.resetGraphics();
		updateCheckBoxxes();
	}
	
	public void updateCheckBoxxes()
	{
		List<GraphicsItem> items = graphics.getGraphicsItems();
		for(int i = 0; i < items.size(); i++)
		{
			boxHolder.get(i).setSelected(items.get(i).getCurrentValue());
		}
	}
	
	public void backBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToSettingsView();
	}

}
