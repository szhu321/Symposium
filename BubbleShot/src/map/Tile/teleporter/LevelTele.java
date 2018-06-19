package map.Tile.teleporter;

import map.Level;
import map.LevelDesign;

public class LevelTele extends Teleporter
{

	public LevelTele(double xPos, double yPos, int id, String filename) {
		super(xPos, yPos, id, filename);
		// TODO Auto-generated constructor stub
	}

	public Level nextLevel()
	{
		return LevelDesign.getRandomLevelDesign(5, 5);
	}
}
