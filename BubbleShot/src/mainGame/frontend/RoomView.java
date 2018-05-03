package mainGame.frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.projectile.Projectile;

public class RoomView
{
	private static boolean displayCharacterNames = true;
	private static boolean displayItemNames = true;
	
	private Canvas canvas;
	private Room room;
	
	public RoomView(Room room)
	{
		this.room = room;
		canvas = new Canvas(room.getRoomPixWidth(), room.getRoomPixHeight());
		drawRoom(canvas.getGraphicsContext2D(), this.room);
	}
	
	public void updateRoom()
	{
		drawRoom(canvas.getGraphicsContext2D(), room);
	}
			
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public static void drawRoom(GraphicsContext gc, Room room)
	{
		drawTiles(gc, room);
		drawItems(gc, room);
		drawCharacters(gc, room);
		drawProjectiles(gc, room);
		drawObstacles(gc, room);
	}
	
	public static void drawTiles(GraphicsContext gc, Room room)
	{
		Tile[][] tiles = room.getTiles();
		for(int row = 0; row < tiles.length; row++)
		{
			for(int col = 0; col < tiles[row].length; col++)
			{
				Tile tile = tiles[row][col];
				gc.drawImage(tile.getSpriteImage(), tile.getXLocation(), tile.getYLocation(), tile.getWidth(), tile.getHeight());
			}
		}
	}
	
	public static void drawObstacles(GraphicsContext gc, Room room)
	{
		for(Obstacle obs : room.getObstacles())
		{
			gc.drawImage(obs.getSpriteImage(), obs.getXLocation(), obs.getYLocation(), obs.getWidth(), obs.getHeight());
		}
	}
	
	public static void drawCharacters(GraphicsContext gc, Room room)
	{
		gc.save();
		for(Character character : room.getCharacters())
		{
			rotateGC(gc, character.getFaceAngle(), character.getXLocation() + character.getWidth() / 2, character.getYLocation() + character.getHeight() / 2);
			gc.drawImage(character.getSpriteImage(), character.getXLocation(), character.getYLocation());
			drawCharacterHoldItem(gc, character);
		}
		gc.restore();
		for(Character character : room.getCharacters())
			if(character instanceof Enemy)
				drawEnemyHealthBar(gc, (Enemy)character);
		if(displayCharacterNames)
		{
			gc.save();
			gc.setFont(new Font("comic sans ms", 20));
			gc.setFill(Color.BLACK);
			for(Character character : room.getCharacters())
			{
				gc.fillText(character.getSpriteName(), character.getXLocation(), character.getYLocation() - 12, character.getWidth());
			}
			gc.restore();
		}
	}
	
	private static void drawEnemyHealthBar(GraphicsContext gc, Enemy enemy)
	{
		HealthBar.drawHealthBar(gc, enemy.getXLocation() - 5, enemy.getYLocation() - 10, enemy.getHealthbar());
	}
	
	private static void drawCharacterHoldItem(GraphicsContext gc, Character character)
	{
		gc.save();
		Item item;
		if(character instanceof Player)
			item = ((Player)character).getCurrentItem();
		else
			item = ((Enemy)character).getWeapon();
		if(item != null)
			gc.drawImage(item.getSpriteImage(), character.getXLocation() + character.getWidth() / 2 + 10, character.getYLocation() + character.getHeight() / 2 - 10, item.getWidth() / 2, item.getHeight() / 2);
		gc.restore();
	}
	
	public static void drawItems(GraphicsContext gc, Room room)
	{
		for(Item item : room.getItems())
		{
			gc.drawImage(item.getSpriteImage(), item.getXLocation(), item.getYLocation());
		}
		if(displayItemNames)
		{
			gc.save();
			gc.setFont(new Font("comic sans ms", 20));
			gc.setFill(Color.BLACK);
			for(Item item : room.getItems())
			{
				gc.fillText(item.getSpriteName(), item.getXLocation(), item.getYLocation() - 5, item.getWidth());
			}
			gc.restore();
		}
	}
	
	public static void drawProjectiles(GraphicsContext gc, Room room)
	{
		gc.save();
		for(Projectile pro : room.getProjectiles())
		{
			rotateGC(gc, pro.getFaceAngle(), pro.getXLocation() + pro.getWidth() / 2, pro.getYLocation() + pro.getHeight() / 2);
			gc.drawImage(pro.getSpriteImage(), pro.getXLocation(), pro.getYLocation());
		}
		gc.restore();
	}
	
	private static void rotateGC(GraphicsContext gc, double angle, double centerX, double centerY)
	{
		Rotate r = new Rotate(angle, centerX, centerY);
		gc.setTransform(new Affine(r));
	}
	
}
