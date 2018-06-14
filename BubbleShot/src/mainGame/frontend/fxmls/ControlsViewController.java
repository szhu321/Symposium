package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import mainGame.GameRunner;
import mainGame.backend.Controls;

public class ControlsViewController implements Initializable
{
	public BorderPane container;
	public TextField upField;
	public TextField downField;
	public TextField leftField;
	public TextField rightField;
	public TextField dropItemField;
	public TextField inventoryField;
	
	private Controls controls;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		controls = GameRunner.getControls();
		upField.setPromptText(controls.getUp().toString());
		upField.setEditable(false);
		downField.setPromptText(controls.getDown().toString());
		leftField.setPromptText(controls.getLeft().toString());
		rightField.setPromptText(controls.getRight().toString());
		dropItemField.setPromptText(controls.getDropItem().toString());
		inventoryField.setPromptText(controls.getInventory().toString());
	}
	
	public void backBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToSettingsView();
	}
	
	public void applyBtnOnclick()
	{
		
	}
	
	public void resetBtnOnclick()
	{
		
	}
}
