package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import mainGame.GameRunner;
import mainGame.SceneTracker;
import mainGame.saving.FileReader;
import sprite.character.player.Player;

public class PlayMenuController implements Initializable
{
	public HBox playerPickerRow;
	private ImageView[] characterImages;
	private Player[] players;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		players = FileReader.loadPlayer();
		
	}
	
	public void backBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
	
	public void createCharacterBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToCharacterCreationView();
	}
	
	public void chooseLevelBtnOnclick() throws Exception
	{
		GameRunner.getSceneTracker().switchToLevelPickerView();
	}
	
	public void startBtnOnclick()
	{
		
	}

	
}
