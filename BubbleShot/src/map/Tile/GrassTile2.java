package map.Tile;

import sprite.character.effect.Effect;
import sprite.character.effect.NoEffect;

public class GrassTile2 extends Tile
{
	public GrassTile2(double x, double y, double width, double height, double faceAngle)
	{
		super("GrassTile", "file:resources/tile/grasstile2.png", new NoEffect(), x, y, width, height, faceAngle);
	}
}
