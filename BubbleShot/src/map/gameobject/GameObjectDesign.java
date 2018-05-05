package map.gameobject;

public class GameObjectDesign 
{
	public static Obstacle getStoneWallDesignOne(double width, double height, double xPos, double yPos, double faceAngle)
	{
		return new Obstacle("Stone Wall", "file:resources/obstacle/wallobstacle.png", width, height, xPos, yPos, faceAngle);
	}
}
