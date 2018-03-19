package sprite;

public abstract class Sprite 
{
	private String spriteName;
	private int xCoord;
	private int yCoord;
	
	protected Sprite(String fileName, int xLocation, int yLocation)
	{
		spriteName = fileName;
		xCoord = xLocation;
		yCoord = yLocation;
	}
	
	public int getXLocation()
	{
		return xCoord;
	}
	
	public int getYLocation()
	{
		return yCoord;
	}
	
	public String getSpriteName()
	{
		return spriteName;
	}
}