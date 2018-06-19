package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import mainGame.GameRunner;
import mainGame.SceneTracker;
import mainGame.saving.FileReader;
import map.LevelDesign;
import sprite.character.player.Player;

public class PlayMenuController implements Initializable
{
	public BorderPane container;
	
	public HBox playerPickerRow;
	private ImageView[] characterImages;
	private Player[] players;
	private Player selectedPlayer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		
		players = FileReader.loadPlayer();
		if(players != null)
		{
			characterImages = new ImageView[players.length];
			for(int i = 0; i < players.length; i++)
			{
				characterImages[i] = new ImageView(players[i].getSpriteImage());
				characterImages[i].setStyle("-fx-opacity:.5");
				characterImages[i].setOnMouseClicked(event -> 
				{
					for(int j = 0; j < characterImages.length; j++)
					{
						characterImages[j].setStyle("-fx-opacity:.5");
						if(characterImages[j].equals(event.getTarget()))
						{
							selectedPlayer = players[j];
							characterImages[j].setStyle("-fx-opacity:1");
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
		GameRunner.createGameManager(LevelDesign.getRandomLevelDesign(4, 4, 1), selectedPlayer);
		Player.setCurrentLevel(selectedPlayer.getLocalLevel());
		GameRunner.startGameManager();
	}

	
}
