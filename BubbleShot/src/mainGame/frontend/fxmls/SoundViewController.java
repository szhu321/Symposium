package mainGame.frontend.fxmls;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import mainGame.GameRunner;
import mainGame.backend.Sounds;

public class SoundViewController implements Initializable
{
	public BorderPane container;
	public Slider backgroundMusicSlider;
	public Slider soundEffectsSlider;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		container.setPrefHeight(GameRunner.getResolutionHeight());
		container.setPrefWidth(GameRunner.getResolutionWidth());
		backgroundMusicSlider.setMin(0);
		backgroundMusicSlider.setMax(1);
		soundEffectsSlider.setMin(0);
		soundEffectsSlider.setMax(1);
		Sounds sounds = GameRunner.getSounds();
		backgroundMusicSlider.setValue(sounds.getBackgroundMusicVolumeProperty().getValue());
		soundEffectsSlider.setValue(sounds.getSoundEffectVolumeProperty().getValue());
		sounds.getBackgroundMusicVolumeProperty().bind(backgroundMusicSlider.valueProperty());
		sounds.getSoundEffectVolumeProperty().bind(soundEffectsSlider.valueProperty());
	}
	
	public void backBtnOnClick() throws Exception
	{
		GameRunner.getSceneTracker().switchToSettingsView();
	}
	
}
