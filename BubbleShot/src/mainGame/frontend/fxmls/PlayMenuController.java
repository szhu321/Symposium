package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mainGame.GameRunner;
import mainGame.SceneTracker;
import mainGame.saving.FileDeleter;
import mainGame.saving.FileReader;
import map.LevelDesign;
import sound.SoundEffects;
import sprite.character.player.Player;

public class PlayMenuController implements Initializable
{
	public BorderPane container;
	public ScrollPane scrollPaneContainer;
	
	public VBox playerPickerRow;
	private ImageView[] characterImages;
	private HBox[] characterSaveSlots;
	private Player[] players;
	private Player selectedPlayer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		container.setId("borderPaneContainer");
		scrollPaneContainer.prefWidthProperty().bind(container.prefWidthProperty());
		
		players = FileReader.loadPlayer();
		if(players != null)
		{
			characterImages = new ImageView[players.length];
			characterSaveSlots = new HBox[players.length];
			for(int i = 0; i < players.length; i++)
			{
				Text playerStatTxt = new Text("Name " + players[i].getSpriteName()+ "\t Current Level " + 
						players[i].getLocalLevel() + "\t Coins " + players[i].getCoins());
				Text dateTxt = new Text("Last Played: " + players[i].getDate().toString());
				characterImages[i] = new ImageView(players[i].getSpriteImage());
				characterImages[i].setFitWidth(100);
				characterImages[i].setFitHeight(100);
				//characterImages[i].setStyle("-fx-opacity:.5");
				characterSaveSlots[i] = new HBox(20);
				characterSaveSlots[i].setId("selectPlayerContainer");
				VBox txtContainer = new VBox();
				txtContainer.setStyle("-fx-font-size:24pt");
				txtContainer.getChildren().addAll(playerStatTxt, dateTxt);
				characterSaveSlots[i].getChildren().addAll(characterImages[i], txtContainer);
				characterSaveSlots[i].setOnMouseClicked(event -> 
				{
					for(int j = 0; j < characterImages.length; j++)
					{
						characterSaveSlots[j].setStyle("-fx-border-width:5px");
						if(characterSaveSlots[j].equals(event.getSource()))
						{
							selectedPlayer = players[j];
							characterSaveSlots[j].setStyle("-fx-border-width:10px");
						}
					}
					//displaySelectedPlayer();
				});
				
			}
			for(int i = 0; i < characterSaveSlots.length; i++)
			{
				playerPickerRow.getChildren().add(characterSaveSlots[i]);
			}
		}
	}
	
	private void displaySelectedPlayer()
	{
		System.out.println(selectedPlayer.getSpriteName());
	}
	
	public void backBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
	
	public void createCharacterBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToCharacterCreationView();
	}
	
	public void chooseLevelBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToLevelPickerView();
	}
	
	public void startBtnOnclick()
	{
		if(selectedPlayer == null)
			return;
		SoundEffects.MENU_SELECT_SOUND.playSound();
		Player.setCurrentLevel(selectedPlayer.getLocalLevel());
		GameRunner.createGameManager(LevelDesign.getRandomLevelDesign(4, 4, selectedPlayer.getLocalLevel()), selectedPlayer);
		//System.out.println("Start Btn Level: " + selectedPlayer.getLocalLevel());
		//System.out.println("Start Btn Level Static Level: " + Player.getCurrentLevel());
		GameRunner.startGameManager();
	}

	public void deleteBtnOnClick() throws Exception
	{
		if(selectedPlayer == null)
			return;
		SoundEffects.MENU_SELECT_SOUND.playSound();
		FileDeleter.deletePlayer(selectedPlayer);
		GameRunner.getSceneTracker().switchToPlayMenuView();
	}
	
}
