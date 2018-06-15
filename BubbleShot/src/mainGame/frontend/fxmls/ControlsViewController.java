package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import mainGame.GameRunner;
import mainGame.backend.Controls;

public class ControlsViewController implements Initializable
{
	public BorderPane container;
	
	public Button upBtn;
	public Button downBtn;
	public Button leftBtn;
	public Button rightBtn;
	public Button sprintBtn;
	
	public Button dropItemBtn;
	public Button inventoryBtn;
	
	private Controls controls;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		controls = GameRunner.getControls();
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
