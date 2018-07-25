package map.obstacle;

/**
 * A simple design for a obstacle.
 */
public class BossShield extends Obstacle
{
	public BossShield(double width, double height, double xPos, double yPos, double faceAngle)
	{
		super("Stone Wall", "file:resources/obstacle/wallobstacle.png", width, height, xPos, yPos, faceAngle);
	}
}
