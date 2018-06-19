package sound;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class BackgroundSound implements Sound
{
	private Media bkgrdSound;
	private MediaPlayer mediaPlayer;
	private double effectSoundLength;
	
	public BackgroundSound(String soundFile, double length)
	{
		bkgrdSound = new Media(new File(soundFile).toURI().toString());
		effectSoundLength = length;
	}

	@Override
	public void playSound()
	{
		mediaPlayer = new MediaPlayer(bkgrdSound);
		//mediaPlayer.setVolume(volume);
		mediaPlayer.setStartTime(Duration.seconds(0));
		mediaPlayer.setStopTime(Duration.seconds(effectSoundLength)); //replace 5 with actual length of audio
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	@Override
	public void stopSound() 
	{
		mediaPlayer.stop();
	}

	public MediaPlayer getMediaPlayer() 
	{
		return mediaPlayer;
	}
	
}
