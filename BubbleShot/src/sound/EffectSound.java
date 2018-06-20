package sound;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class EffectSound implements Sound
{
	private String soundFile;
	private AudioClip audioClip;
	
	public EffectSound(String soundFile)
	{
		this.soundFile = soundFile;
		audioClip = new AudioClip("file:" + soundFile);
		audioClip.setVolume(0.1);
	}

	@Override
	public void playSound() 
	{
		audioClip.play();
	}
	
	public void stopSound() 
	{
		audioClip.stop();
	}
}
