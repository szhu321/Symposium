package sprite.character.movement;

import java.util.ArrayList;
import java.util.List;

/**
 * The movement path is used in movement drive.
 * It creates a class with a list of coords that the character will follow.
 * The coord at position 0 in the list is the first coord the character will attempt to reach.
 */
public class MovementPath
{
	private List<Coord> coords;
	private boolean loop;
	private int currentIdx;
	
	/**
	 * Creates a movement path for a character to follow;
	 * @param coords - a list of coords the character follows, starting at position 0.
	 * @param loop - does the path loop? If true the player will follow path until end before going back to coord at position 0.
	 */
	public MovementPath(List<Coord> coords, boolean loop)
	{
		this.coords = coords;
		this.loop = loop;
		currentIdx = 0;
	}

	public List<Coord> getCoords()
	{
		return coords;
	}

	public boolean isLoop()
	{
		return loop;
	}

	public void setLoop(boolean loop) 
	{
		this.loop = loop;
	}
	
	/**
	 * Returns the next coord in the coords list.
	 * If loop is false and idx is outofbounds return null.
	 * If loop is true and idx is outofbounds set idx to -1;
	 * @return The next coord in the path.
	 */
	public Coord getNextCoord()
	{
		if(coords!=null)
		{
			if(currentIdx >= coords.size())
				if(loop)
					currentIdx = 0;
				else
					return null;
			currentIdx++;
			return coords.get(currentIdx - 1); 
		}
		return null;
	}

	public void setCoords(List<Coord> coords) {
		this.coords = coords;
		currentIdx=0;
	}
}
