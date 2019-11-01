package sprite.animation;

import javafx.scene.image.Image;

public class AniState
{
	private String name;
	private Image[] frames;
	private int framesPerSec;
	private int currentFrame;
	
	public AniState(String name, Image[] frames, int framesPerSec)
	{
		this.name = name;
		this.frames = frames;
		this.framesPerSec = framesPerSec;
	}
	
	public String toString()
	{
		return name;
	}
}
