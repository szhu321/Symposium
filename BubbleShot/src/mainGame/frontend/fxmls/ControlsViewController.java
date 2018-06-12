package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import mainGame.GameRunner;

public class ControlsViewController implements Initializable
{
	public BorderPane container;
	public TextField upField;
	public TextField downField;
	public TextField leftField;
	public TextField rightField;
	public TextField dropItemField;
	public TextField inventoryField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
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
