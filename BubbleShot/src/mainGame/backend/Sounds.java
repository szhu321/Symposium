package mainGame.backend;

import java.util.HashMap;

import sound.EffectSound;

public class Sounds
{
	private double backgroundMusicVolume;
	private double soundEffectVolume;
	private HashMap<String, EffectSound> soundEffect;
	
	public Sounds()
	{
		resetSoundSettings();
		loadSounds();
	}
	
	private void loadSounds()
	{
		soundEffect.put("pewpew", new EffectSound("resources/soundEffects/pew_pew.mp3", .5));
		soundEffect.put("gunshot", new EffectSound("resources/soundEffects/gunShot.wav", .5));
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
