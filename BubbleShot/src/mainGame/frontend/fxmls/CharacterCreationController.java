package mainGame.frontend.fxmls;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import mainGame.GameRunner;
import mainGame.saving.FileSaver;
import myutilities.FileUtil;
import sprite.character.player.PlayerDesign;

public class CharacterCreationController implements Initializable
{
	public BorderPane container;
	
	public Canvas playIconView;
	public TextField playerNameField;
	private int imgIdx;
	private File[] files;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		grabImages();
		displayImage();
	}
	
	private void grabImages()
	{
		files = FileUtil.getAllPngFilesFromDir("resources/player");
	}
	
	private void displayImage()
	{
		playIconView.getGraphicsContext2D().clearRect(0, 0, playIconView.getWidth(), playIconView.getHeight());
		playIconView.getGraphicsContext2D().drawImage(new Image("file:" + files[imgIdx]), 0, 0, playIconView.getWidth(), playIconView.getHeight());
	}
	
	public void nextIconBtnOnclick()
	{
		imgIdx++;
		imgIdx %= files.length;
		displayImage();
	}
	
	public void previousIconBtnOnclick()
	{
		imgIdx--;
		if(imgIdx < 0)
			imgIdx = files.length - 1;
		displayImage();
	}
	
	public void backBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToPlayMenuView();
	}
	
	public void createCharacterBtn() throws Exception
	{
		String str = playerNameField.getText();
		if(str != null && !str.equals(""))
			FileSaver.savePlayer(PlayerDesign.getSimpleStarterPlayer(str, "file:" + files[imgIdx]));
		GameRunner.getSceneTracker().switchToPlayMenuView();
	}
}
