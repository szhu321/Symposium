package map.Tile;

import sprite.character.effect.Effect;
import sprite.character.effect.SpeedEffect;

public class TileDesign
{
	public static Tile getGrassTileDesignOne()
	{
		Tile result = new Tile("GrassTile", "file:resources/tile/grasstile.png");
		return result;
	}
	
	public static Tile getStoneTileDesignOne()
	{
		Effect effect = new SpeedEffect(1, 1.2, false);
		Tile result = new Tile("StoneTile", "file:resources/tile/stonetile.png", effect);
		return result;
	}
	
	public static Tile getMudTileDesignOne()
	{
		Effect effect = new SpeedEffect(2, .75, false);
		Tile result = new Tile("MudTile", "file:resources/tile/mudtile.png", effect);
		return result;
	}
}
