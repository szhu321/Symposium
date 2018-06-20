package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mainGame.GameRunner;
import mainGame.SceneTracker;
import mainGame.saving.FileReader;
import map.LevelDesign;
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
		scrollPaneContainer.prefWidthProperty().bind(container.prefWidthProperty().divide(2));
		
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
				VBox txtContainer = new VBox();
				txtContainer.setStyle("-fx-font-size:24pt");
				txtContainer.getChildren().addAll(playerStatTxt, dateTxt);
				characterSaveSlots[i] = new HBox(20);
				characterSaveSlots[i].getChildren().addAll(characterImages[i], txtContainer);
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
