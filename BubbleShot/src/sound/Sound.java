package sound;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound 
{
	private Media sound;
	private MediaPlayer mediaPlayer;
	
	public Sound(String soundFile)
	{
		sound = new Media(new File(soundFile).toURI().toString());
	}
	
	public void playSound(double volume)
	{
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setVolume(volume);
		mediaPlayer.play();
	}
	
	public void stopSound()
	{
		mediaPlayer.stop();
	}
}
