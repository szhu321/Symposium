package sound;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class EffectSound implements Sound, Runnable
{
	private Media effectSound;
	private MediaPlayer mediaPlayer;
	private String soundFile;
	private List<MediaPlayer> players;
	private double duration;
	//in seconds
	//private double effectSoundLength;
	
	public EffectSound(String soundFile, double duration)
	{
		this.soundFile = soundFile;
		effectSound = new Media(new File(soundFile).toURI().toString());
		mediaPlayer = new MediaPlayer(effectSound);
		players = new ArrayList<MediaPlayer>();
		this.duration = duration;
	}

	@Override
	public void playSound() 
	{
		
		//mediaPlayer.setVolume(volume);
		//mediaPlayer.setStartTime(Duration.seconds(0));
		
		//mediaPlayer.setAutoPlay(true);
		//stopSound();
		mediaPlayer = new MediaPlayer(effectSound);
		mediaPlayer.setVolume(.1);
		players.add(mediaPlayer);
		mediaPlayer.setStopTime(Duration.seconds(duration));
		mediaPlayer.setOnEndOfMedia(this);
		mediaPlayer.play();
		//mediaPlayer.d
		
	}
	
	@Override
	public void run()
	{
		players.remove(0).dispose();
		//System.out.println(players.size());
	}

	@Override
	public void stopSound() 
	{
		mediaPlayer.stop();
	}

	public void load()
	{
		
	}
}
