package mainGame.frontend.fxmls;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import mainGame.GameRunner;
import mainGame.saving.FileReader;
import mainGame.saving.FileSaver;
import map.LevelDesign;
import myutilities.FileUtil;
import sound.SoundEffects;
import sprite.character.player.Player;
import sprite.character.player.PlayerDesign;

public class CharacterCreationController implements Initializable
{
	public BorderPane container;
	
	public Canvas playIconView;
	public TextField playerNameField;
	public Label messageLabel;
	
	private Timeline timeline;
	private KeyFrame kf;
	private int imgIdx;
	private File[] files;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		container.setId("borderPaneContainer");
		grabImages();
		displayImage();
		generateClearMessageLabelTimer();
	}
	
	private void generateClearMessageLabelTimer()
	{
		timeline = new Timeline();
		kf = new KeyFrame(Duration.seconds(2), event -> 
		{
			messageLabel.setText("");
		});
		timeline.getKeyFrames().add(kf);
	}
	
	private void grabImages()
	{
		files = FileUtil.getFilesFromDir("resources/player", "png");
	}
	
	private void displayImage()
	{
		playIconView.getGraphicsContext2D().clearRect(0, 0, playIconView.getWidth(), playIconView.getHeight());
		playIconView.getGraphicsContext2D().drawImage(new Image("file:" + files[imgIdx]), 0, 0, playIconView.getWidth(), playIconView.getHeight());
	}
	
	public void nextIconBtnOnclick()
	{
		SoundEffects.MOUSE_CLICK_SOUND.playSound();
		imgIdx++;
		imgIdx %= files.length;
		displayImage();
	}
	
	public void previousIconBtnOnclick()
	{
		SoundEffects.MOUSE_CLICK_SOUND.playSound();
		imgIdx--;
		if(imgIdx < 0)
			imgIdx = files.length - 1;
		displayImage();
	}
	
	public void backBtnOnclick() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		GameRunner.getSceneTracker().switchToMainMenuView();
	}
	
	public void startGameBtn() throws Exception
	{
		SoundEffects.MENU_SELECT_SOUND.playSound();
		String str = playerNameField.getText();
		if(str == null || str.equals(""))
		{
			messageLabel.setText("Enter A Name");
			runMessageClearer();
		}
		else
		{
			Player[] players = FileReader.loadPlayer();
			if(players != null)
			{
				for(Player p : players)
				{
					if(p.getSpriteName().equals(str))
					{
						messageLabel.setText("Name Already Taken");
						runMessageClearer();
						return;
					}
				}
			}
			Player player = PlayerDesign.getSimpleStarterPlayer(str, "file:" + files[imgIdx]);
			player.setDate(new Date());
			FileSaver.savePlayer(player);
			player.reloadObject();
			startGame(player);
		}		
		//GameRunner.getSceneTracker().switchToPlayMenuView();
	}
	
	private void startGame(Player player)
	{
		Player.setCurrentLevel(player.getLocalLevel());
		GameRunner.createGameManager(LevelDesign.getRandomLevelDesign(4, 4, player.getLocalLevel()), player);
		GameRunner.startGameManager();
	}
	
	private void runMessageClearer()
	{
		
		timeline.playFromStart();
	}
}
