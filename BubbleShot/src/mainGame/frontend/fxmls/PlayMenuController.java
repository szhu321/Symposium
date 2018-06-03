package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import mainGame.GameRunner;
import mainGame.SceneTracker;
import mainGame.saving.FileReader;
import map.LevelDesign;
import sprite.character.player.Player;

public class PlayMenuController implements Initializable
{
	public HBox playerPickerRow;
	private ImageView[] characterImages;
	private Player[] players;
	private Player selectedPlayer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		players = FileReader.loadPlayer();
		if(players != null)
		{
			characterImages = new ImageView[players.length];
			for(int i = 0; i < players.length; i++)
			{
				characterImages[i] = new ImageView(players[i].getSpriteImage());
				characterImages[i].setOnMouseClicked(event -> 
				{
					for(int j = 0; j < characterImages.length; j++)
					{
						if(characterImages[j].equals(event.getTarget()))
						{
							selectedPlayer = players[j];
							characterImages[j].setStyle("-fx-opacity:1");
						}
						else
						{
							characterImages[j].setStyle("-fx-opacity:0.5");
						}
					}
					//displaySelectedPlayer();
				});
			}
			for(int i = 0; i < characterImages.length; i++)
			{
				playerPickerRow.getChildren().add(i, characterImages[i]);
			}
		}
	}
	
	private void displaySelectedPlayer()
	{
		System.out.println(selectedPlayer.getSpriteName());
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
		if(selectedPlayer == null)
			return;
		GameRunner.createGameManager(LevelDesign.getLevelDesignOne(), selectedPlayer);
		GameRunner.startGameManager();
	}

	
}
