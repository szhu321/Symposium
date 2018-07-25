package map.Tile;

import sprite.character.effect.NoEffect;

public class GrassTile extends Tile
{
	public GrassTile(double x, double y, double width, double height, double faceAngle)
	{
		super("GrassTile", "file:resources/tile/grasstile.png", new NoEffect(), x,y,width,height,faceAngle);
	}
}
