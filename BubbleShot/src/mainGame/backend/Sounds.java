package mainGame.backend;

import java.util.HashMap;

import sound.EffectSound;

public class Sounds
{
	private double backgroundMusicVolume;
	private double soundEffectVolume;
	
	public Sounds()
	{
		resetSoundSettings();
	}
	
	public void resetSoundSettings()
	{
		backgroundMusicVolume = 0.5;
		soundEffectVolume = 0.3;
	}

	public double getBackgroundMusicVolume() 
	{
		return backgroundMusicVolume;
	}

	public double getSoundEffectVolume()
	{
		return soundEffectVolume;
	}

	public void setBackgroundMusicVolume(double backgroundMusicVolume)
	{
		this.backgroundMusicVolume = backgroundMusicVolume;
	}

	public void setSoundEffectVolume(double soundEffectVolume) 
	{
		this.soundEffectVolume = soundEffectVolume;
	}
}
