package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import mainGame.GameRunner;
import mainGame.backend.Controls;
import myutilities.ControlItem;
import sound.SoundEffects;

public class ControlsViewController implements Initializable
{
	public BorderPane container;
	public GridPane controlItemGrid;
	public ScrollPane controlContainer;
	
	private Controls controls;
	
	private ControlItem selectedControlItem;
	private List<Button> buttonsHolder;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		controlItemGrid.setPrefWidth(GameRunner.getResolutionWidth() - 50);
		controlContainer.setPrefHeight(GameRunner.getResolutionHeight() - 100);
		controls = GameRunner.getControls();
		loadControlItemGrid();
	}
	
	private void loadControlItemGrid()
	{
		List<ControlItem> items = controls.getControlItems();
		buttonsHolder = new ArrayList<Button>();
		for(int i = 0; i < items.size(); i++)
		{
			ControlItem currentItem = items.get(i);
			currentItem.setId(i);
			Label text = new Label(currentItem.getControlName());
			
			Button inputBtn = new Button(currentItem.getCurrentControlStr());
			inputBtn.setOnMouseClicked(event -> selectControlItem(currentItem.getId()));
			
			buttonsHolder.add(inputBtn);
			controlItemGrid.add(text, 1, i);
			controlItemGrid.add(inputBtn, 2, i);
		}
	}
	
	public void backBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToSettingsView();
	}
	
	public void selectControlItem(int id)
	{
		if(selectedControlItem != null)
			return;
		selectedControlItem = controls.getControlItems().get(id);
		buttonsHolder.get(id).setText("> " + selectedControlItem.getCurrentControlStr() + " <");
		buttonsHolder.get(id).setDisable(true);
		addEventHandlers();
		//selectedControlItem.
	}
	
	private void addEventHandlers()
	{
		controlContainer.setOnKeyPressed(event -> readKeyPressed(event));
		controlContainer.setOnMousePressed(event -> readMousePressed(event));
	}
	
	private void removeEventHandlers()
	{
		controlContainer.setOnKeyPressed(null);
		controlContainer.setOnMousePressed(null);
	}
	
	private void readKeyPressed(KeyEvent event)
	{
		selectedControlItem.setCurrentControlStr(event.getCode().toString());
		buttonsHolder.get(selectedControlItem.getId()).setText(selectedControlItem.getCurrentControlStr());
		buttonsHolder.get(selectedControlItem.getId()).setDisable(false);
		selectedControlItem = null;
		removeEventHandlers();
	}
	
	private void readMousePressed(MouseEvent event)
	{
		selectedControlItem.setCurrentControlStr(event.getButton().toString());
		buttonsHolder.get(selectedControlItem.getId()).setText("Mouse " + selectedControlItem.getCurrentControlStr());
		buttonsHolder.get(selectedControlItem.getId()).setDisable(false);
		selectedControlItem = null;
		removeEventHandlers();
	}
	
	public void applyBtnOnclick()
	{
		
	}
	
	public void resetBtnOnclick()
	{
		
	}
}
