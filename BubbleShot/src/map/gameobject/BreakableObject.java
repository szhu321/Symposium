package map.gameobject;

public class BreakableObject extends GameObject
{
	private double currentHitpoints;
	private double defaultHitpoints;
	
	public BreakableObject(String spriteName, String fileName, double xLocation, double yLocation, double width,
			double height, double faceAngle, double hitpoints) 
	{
		super(spriteName, fileName, xLocation, yLocation, width, height, faceAngle);
		
	}

	public double getCurrentHitpoints() 
	{
		return currentHitpoints;
	}

	public double getDefaultHitpoints() 
	{
		return defaultHitpoints;
	}

	public void setCurrentHitpoints(double currentHitpoints) 
	{
		this.currentHitpoints = currentHitpoints;
	}

	public void setDefaultHitpoints(double defaultHitpoints)
	{
		this.defaultHitpoints = defaultHitpoints;
	}
	
	
	
}
