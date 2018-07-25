package sprite.character.movement;

public class Coord
{
	private int x;
	private int y;
	
	public Coord(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public void setY(int y) 
	{
		this.y = y;
	}
	
	public boolean equals(Coord other)
	{
		if(x == other.x && y == other.x)
			return true;
		return false;
	}
	
	public String toString()
	{
		return "( " + x + ", " + y + " )";
	}
}
