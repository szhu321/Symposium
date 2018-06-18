package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import mainGame.GameRunner;
import mainGame.backend.Graphics;

public class GraphicsViewController implements Initializable
{
	public BorderPane container;
	
	public ScrollPane graphicsContainer;
	public GridPane graphicsItemGrid;
	
	public Graphics graphics;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		graphicsItemGrid.setPrefWidth(GameRunner.getResolutionWidth() - 50);
		graphicsContainer.setPrefHeight(GameRunner.getResolutionHeight() - 100);
		
	}
	
	public void resetBtnOnclick()
	{
		
	}
	
	public void backBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToSettingsView();
	}



	
}
