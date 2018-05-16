package map.Tile;

import sprite.character.effect.Effect;
import sprite.character.effect.SpeedEffect;

public class TileDesign
{
	public static Tile getGrassTileDesignOne(double x, double y, double width, double height, double faceAngle)
	{
		Tile result = new Tile("GrassTile", "file:resources/tile/grasstile.png", x, y, width, height, faceAngle);
		return result;
	}
	
	public static Tile getStoneTileDesignOne(double x, double y, double width, double height, double faceAngle)
	{
		Effect effect = SpeedEffect.STONE_TILE_EFFECT;
		Tile result = new Tile("StoneTile", "file:resources/tile/icecreamtile.png", effect, x, y, width, height, faceAngle);
		return result;
	}
	
	public static Tile getMudTileDesignOne(double x, double y, double width, double height, double faceAngle)
	{
		Effect effect = SpeedEffect.MUD_TILE_EFFECT;
		Tile result = new Tile("MudTile", "file:resources/tile/mudtile.png", effect, x, y, width, height, faceAngle);
		return result;
	}
}
