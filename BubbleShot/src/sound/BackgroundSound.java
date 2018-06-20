package sound;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import mainGame.GameRunner;

public class BackgroundSound implements Sound
{
	private Media bkgrdSound;
	private MediaPlayer mediaPlayer;
	private static List<MediaPlayer> players = new ArrayList<MediaPlayer>();
	private double effectSoundLength;
	
	public BackgroundSound(String soundFile)
	{
		bkgrdSound = new Media(new File(soundFile).toURI().toString());
		mediaPlayer = new MediaPlayer(bkgrdSound);
		players.add(mediaPlayer);
		mediaPlayer.volumeProperty().bind(GameRunner.getSounds().getBackgroundMusicVolumeProperty());
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		//effectSoundLength = length;
	}

	@Override
	public void playSound()
	{
		stopAllBackgroundMusic();
		mediaPlayer.setStartTime(Duration.seconds(0));
		mediaPlayer.play();
	}

	@Override
	public void stopSound() 
	{
		mediaPlayer.stop();
	}
	
	public static void stopAllBackgroundMusic()
	{
		for(MediaPlayer player : players)
		{
			player.stop();
		}
	}

	public MediaPlayer getMediaPlayer() 
	{
		return mediaPlayer;
	}
	
}
