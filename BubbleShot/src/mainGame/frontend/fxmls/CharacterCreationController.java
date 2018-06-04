package mainGame.frontend.fxmls;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mainGame.GameRunner;
import mainGame.saving.FileSaver;
import myutilities.FileUtil;
import sprite.character.player.PlayerDesign;

public class CharacterCreationController implements Initializable
{
	public ImageView playIconView;
	public TextField playerNameField;
	private int imgIdx;
	private File[] files;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		grabImages();
		displayImage();
	}
	
	private void grabImages()
	{
		files = FileUtil.getAllPngFilesFromDir("resources/player");
	}
	
	private void displayImage()
	{
		playIconView.setImage(new Image("file:" + files[imgIdx]));
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
