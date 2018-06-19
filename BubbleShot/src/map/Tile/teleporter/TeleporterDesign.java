package map.Tile.teleporter;

import map.Tile.Tile;

public class TeleporterDesign 
{
	public static Teleporter getRegularTeleporter(double x, double y, int id)
	{
		Teleporter result = new Teleporter(x,y,id,"file:resources/tile/teleporttile.png");
		return result;
	}
	
	public static Teleporter getBossTeleporter(double x, double y, int id)
	{
		Teleporter result = new Teleporter(x,y,id,"file:resources/tile/bossteleporttile.png");
		return result;
	}
	
	public static LevelTele getLevelTeleporter(double x, double y, int id)
	{
		LevelTele result = new LevelTele(x,y,id,"file:resources/tile/levelteleporttile.png");
		return result;
	}
}
