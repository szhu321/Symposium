package map.Tile;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sprite.Sprite;
import sprite.character.effect.Effect;
import sprite.character.effect.NoEffect;

/**
 * A single tile that can be arranged into a map.
 * @author Sheng
 *
 */
public class Tile extends Sprite
{
	private String name;
	private String fileName;
	private Image img;
	private ImageView imgView;
	private Effect effect;
	
	/**
	 * @param name - Name of the tile.
	 * @param fileName - File path for the tile.
	 * @param effects - Effects the tile will have on characters.
	 */
	public Tile(String name, String fileName, Effect effect, double xPos, double yPos, double width, double height, double faceAngle)
	{
		super(name, fileName, xPos, yPos, width, height, faceAngle);
		this.name = name;
		this.fileName = fileName;
		this.effect = effect;
		img = new Image(fileName, 100, 100, false, false);
		imgView = new ImageView(img);
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
	
	public ImageView getImageView() {return imgView;}
	public Image getImg() {return img;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public void setEffects(Effect effects) {this.effect = effects;}
	public Effect getEffects() {return effect;}
	public String getFileName() {return fileName;}
	
	public String toString()
	{
		return name+" At: "+ fileName;
	}
	
	/**
	 * A grass tile. This Tile has no effects.
	 */
	//public static final Tile GRASS_TILE_ONE = new Tile("GrassTile", "file:resources/tile/grasstile.png", new Effects());
	
	/**
	 * A grass tile. This Tile has no effects.
	 */
	//public static final Tile GRASS_TILE_TWO = new Tile("GrassTile", "file:resources/tile/grasstile2.png", new Effects());
}
