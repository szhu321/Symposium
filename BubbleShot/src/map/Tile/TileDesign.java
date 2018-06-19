package map.Tile;

import myutilities.StaticImage;
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
		Tile result = new Tile("StoneTile", StaticImage.STONE_TILE_IMAGE, effect, x, y, width, height, faceAngle);
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
		Tile result = new Tile("LavaTile", StaticImage.LAVA_TILE_IMAGE, effect, x, y, width, height, faceAngle);
		return result;
	}
	
	public static Tile getLevelTeleTileDesignOne(double x, double y, double width, double height, double faceAngle)
	{
		Effect effect = NoEffect.NO_EFFECT;
		Tile result = new Tile("LeveTile", "file:resources/tile/bossteleporttile.png", effect, x, y, width, height, faceAngle);
		return result;
	}
}
