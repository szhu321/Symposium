package sprite.character.movement;

import java.util.ArrayList;
import java.util.List;

import sprite.character.Character;

/**
 * The epic drive that drives a character forward(moves the character).
 * The MovementDrive requires a Movement Path that the player will follow.
 * The runDrive method returns the x and y deltas the player should perform.	
 */
public class MovementDrive
{
	private Character character;
	private List<MovementPath> paths;
	private Coord currentCoord;
	
	public MovementDrive(Character character)
	{
		paths = new ArrayList<MovementPath>();
		this.character = character;
	}
	
	/**
	 * Changes the movement path.
	 * @param path The new movement path list.
	 */
	public void updateMovementPath(List<MovementPath> paths)
	{
		this.paths = paths;
		currentCoord = paths.get(0).getNextCoord();
	}
	
	/**
	 * Changes the movement path.
	 * @param path The new movement path.
	 */
	public void updateMovementPath(MovementPath path)
	{
		List<MovementPath> paths = new ArrayList<MovementPath>();
		paths.add(path);
		this.updateMovementPath(paths);
	}
	
	/**
	 * 
	 * @param sec The amount of time passed in seconds.
	 * @return returns a double array of length 2. the x and y direction. 
	 * Returns null when the path is completely traveled.
	 */
	public double[] runDrive(double sec)
	{
		updateCurrentCoord();
		if(currentCoord == null)
			return null;
		return caculateDeltas(sec);
	}
	
	private double[] caculateDeltas(double sec)
	{
		double[] deltas = new double[2];
		double characterMovedistance = character.getSpeed() * sec;
		if(inRange((int)character.getXCenter(), currentCoord.getX(), 3))
			deltas[0] = 0;
		else if(character.getXCenter() > currentCoord.getX())
			deltas[0] = -(characterMovedistance);
		else if(character.getXCenter() < currentCoord.getX())
			deltas[0] = (characterMovedistance);
		if(inRange((int)character.getYCenter(), currentCoord.getY(), 3))
			deltas[1] = 0;
		else if(character.getYCenter() > currentCoord.getY())
			deltas[1] = -(characterMovedistance);
		else if(character.getYCenter() < currentCoord.getY())
			deltas[1] = (characterMovedistance);	
		return deltas;
	}
	
	private void updateCurrentCoord()
	{
		if(currentCoord!=null)
		{
			if(inRange(currentCoord.getX(), (int)character.getXCenter(), 15) && inRange(currentCoord.getY(), (int)character.getYCenter(), 15))
			{
				currentCoord = null;
				while(currentCoord == null && paths.size() > 0)
				{
					currentCoord = paths.get(0).getNextCoord();
					if(currentCoord == null)
						paths.remove(0);
				}
			}
		}
	}	
	
	private boolean inRange(int num1, int num2, int range)
	{
		if(Math.abs(num1 - num2) < range)
			return true;
		return false;
	}
}
