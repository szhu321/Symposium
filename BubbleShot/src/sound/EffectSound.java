package sound;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class EffectSound implements Sound
{
	private Media effectSound;
	private MediaPlayer mediaPlayer;
	//in seconds
	private double effectSoundLength;
	
	public void EffectSound(String soundFile, double eSLength)
	{
		effectSound = new Media(new File(soundFile).toURI().toString());
		effectSoundLength = eSLength;
	}

	@Override
	public void playSound(double volume) 
	{
		mediaPlayer = new MediaPlayer(effectSound);
		mediaPlayer.setVolume(volume);
		mediaPlayer.setStartTime(Duration.seconds(0));
		mediaPlayer.setStopTime(Duration.seconds(effectSoundLength));
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();
	}

	@Override
	public void stopSound() 
	{
		mediaPlayer.stop();
	}
}
