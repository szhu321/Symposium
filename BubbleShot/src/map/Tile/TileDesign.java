package map.Tile;

import sprite.character.effect.Effect;
import sprite.character.effect.HealthEffect;
import sprite.character.effect.NoEffect;
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
		Effect effect = NoEffect.NO_EFFECT;
		Tile result = new Tile("StoneTile", "file:resources/tile/stonetile.png", effect, x, y, width, height, faceAngle);
		return result;
	}
	
	public static Tile getMudTileDesignOne(double x, double y, double width, double height, double faceAngle)
	{
		Effect effect = SpeedEffect.MUD_TILE_EFFECT;
		Tile result = new Tile("MudTile", "file:resources/tile/mudtile.png", effect, x, y, width, height, faceAngle);
		return result;
	}
	
	public static Tile getLavaTileDesignOne(double x, double y, double width, double height, double faceAngle)
	{
		Effect effect = HealthEffect.LAVA_TILE_EFFECT;
		Tile result = new Tile("LavaTile", "file:resources/tile/lavatile.png", effect, x, y, width, height, faceAngle);
		return result;
	}
}
