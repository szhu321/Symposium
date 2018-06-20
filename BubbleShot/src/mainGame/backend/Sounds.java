package mainGame.backend;

import java.util.HashMap;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import sound.EffectSound;

public class Sounds
{
	private DoubleProperty backgroundMusicVolumeProperty;
	private DoubleProperty soundEffectVolumeProperty;
	
	public Sounds()
	{
		resetSoundSettings();
	}
	
	public void resetSoundSettings()
	{
		backgroundMusicVolumeProperty = new SimpleDoubleProperty(0.5);
		soundEffectVolumeProperty = new SimpleDoubleProperty(0.3);
	}

	public DoubleProperty getBackgroundMusicVolumeProperty()
	{
		return backgroundMusicVolumeProperty;
	}

	public DoubleProperty getSoundEffectVolumeProperty()
	{
		return soundEffectVolumeProperty;
	}
}
