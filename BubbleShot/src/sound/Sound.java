package sound;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public interface Sound 
{	
	public void playSound(double volume);
	public void stopSound();
}
