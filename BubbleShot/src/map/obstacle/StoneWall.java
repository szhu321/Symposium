package map.obstacle;

public class StoneWall extends Obstacle
{
	public StoneWall(double width, double height, double xPos, double yPos)
	{
		super("Stone Wall", "file:resources/obstacle/wallobstacle.png", width, height, xPos, yPos);
	}
}
