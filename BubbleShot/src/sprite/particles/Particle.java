package sprite.particles;

import sprite.Sprite;

public abstract class Particle extends Sprite
{
	private double time;
	
	public Particle(String spriteName, String fileName, double xLocation, double yLocation, double width,
			double height, double faceAngle)
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, faceAngle);
		
	}
	
	public abstract void run(double sec);
}
