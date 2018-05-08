package map.Tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sprite.Sprite;
import sprite.character.effect.Effect;
import sprite.character.effect.NoEffect;

/**
 * A single tile that can be arranged onto a room.
 * All tiles will have a effect on characters that steps over them.
 * Ex. MudTile - slowing effect
 * 	   StoneTile - speeding effect
 * 	   GrassTile - no effect
 */
public class Tile extends Sprite
{
	private Effect effect;
	private int fScore;
	private int hScore;
	private int gScore;
	private Tile cameFrom;
	
	/**
	 * @param name - Name of the tile.
	 * @param fileName - File path for the tile.
	 * @param effects - Effects the tile will have on characters.
	 */
	public Tile(String name, String fileName, Effect effect, double xPos, double yPos, double width, double height, double faceAngle)
	{
		super(name, fileName, xPos, yPos, width, height, faceAngle);
		this.effect = effect;
	}
	
	/**
	 * @param name - Name of the tile.
	 * @param fileName - File path for the tile.
	 */
	public Tile(String name, String fileName, double xPos, double yPos, double width, double height, double faceAngle)
	{
		this(name, fileName, new NoEffect(), xPos, yPos, width, height, faceAngle);
	}
	
	/**
	 * @param fileName - File path for the tile.
	 */
	public Tile(String fileName, double xPos, double yPos, double width, double height, double faceAngle)
	{
		this("Unnamed", fileName, new NoEffect(), xPos, yPos, width, height, faceAngle);
	}
	
	public void setEffects(Effect effects) {this.effect = effects;}
	public Effect getEffects() {return effect;}
	public void setfScore(int fScore) {this.fScore=fScore;}
	public int getfScore(){return fScore;}
	public void setgScore(int gScore) {this.gScore=gScore;}
	public int getgScore(){return gScore;}
	public void sethScore(int hScore) {this.hScore=hScore;}
	public int gethScore(){return hScore;}
	public void setCame(Tile cameFrom) {this.cameFrom=cameFrom;}
	public Tile getCame() {return cameFrom;}

}
