package mainGame.frontend.fxmls;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
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
	
	public Label messageLabel;
	public VBox playerPickerRow;
	private ImageView[] characterImages;
	private HBox[] characterSaveSlots;
	private Player[] players;
	private Player selectedPlayer;
	private Timeline timeline;
	private KeyFrame kf;
	
	private int deleteBtnClick;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		container.setId("borderPaneContainer");
		scrollPaneContainer.prefWidthProperty().bind(container.prefWidthProperty());
		deleteBtnClick = 0;
		players = FileReader.loadPlayer();
		if(players != null && players.length > 0)
		{
			characterImages = new ImageView[players.length];
			characterSaveSlots = new HBox[players.length];
			for(int i = 0; i < players.length; i++)
			{
				Text playerStatTxt = new Text("Name " + players[i].getSpriteName()+ "\t Current Level " + 
						players[i].getLocalLevel() + "\t Coins " + players[i].getCoins());
				Text dateTxt = new Text("Last Saved: " + players[i].getDate().toString());
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
							SoundEffects.MOUSE_CLICK_SOUND.playSound();
							selectedPlayer = players[j];
							deleteBtnClick = 0;
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
		else
		{
			messageLabel.setText("No Characters");
		}
		generateClearMessageLabelTimer();
	}
	
	private void generateClearMessageLabelTimer()
	{
		timeline = new Timeline();
		kf = new KeyFrame(Duration.seconds(2), event -> 
		{
			messageLabel.setText("");
			deleteBtnClick = 0;
		});
		timeline.getKeyFrames().add(kf);
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
		{
			messageLabel.setText("Select A Character Before Starting");
			clearMessage();
			return;
		}
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
		{
			messageLabel.setText("Select A Character Before Deleting");
			clearMessage();
			return;
		}
		if(deleteBtnClick == 1)
		{
			SoundEffects.MENU_SELECT_SOUND.playSound();
			FileDeleter.deletePlayer(selectedPlayer);
			GameRunner.getSceneTracker().switchToPlayMenuView();
		}
		else
		{
			deleteBtnClick = 1;
			messageLabel.setText("Press Again To Delete");
			clearMessage();
		}
	}
	
	public void clearMessage()
	{
		timeline.playFromStart();
	}
	
}
