package mainGame.frontend;

import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import mainGame.GameRunner;
import mainGame.backend.Graphics;
import map.Room;
import map.Tile.Tile;
import map.Tile.teleporter.Teleporter;
import map.obstacle.Obstacle;
import map.obstacle.Shop;
import map.obstacle.StoneWall;
import myutilities.MyMath;
import sprite.character.Character;
import sprite.character.enemy.Enemy;
import sprite.character.player.Player;
import sprite.item.Item;
import sprite.projectile.Projectile;

public class RoomView
{
//	public static boolean displayCharacterNames = false;
//	public static boolean displayItemNames = false;
//	public static boolean displayCharacterShadow = true;
//	public static boolean displayItemShadow = true;
//	public static boolean displayObstacleShadow = true;
//	public static boolean displayItemRotating = true;
//	public static boolean displayCharacterEffects = true;
//	public static boolean displayShadowMode = false;
//	public static boolean displayBlindMode = false;
	private static Graphics graphics = GameRunner.getGraphics();
	
	private Canvas canvas;
	private Room room;
	
	private static double timePassed = 0.0;
	private static long passTime = System.nanoTime();
	
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
		timePassed += (double)(System.nanoTime() - passTime) / 1000000.0;
		passTime = System.nanoTime();
		
		
		drawTiles(gc, room);
		drawItems(gc, room);
		drawCharacters(gc, room);
		drawProjectiles(gc, room);
		
		shadowMode(gc, room);
		drawObstacles(gc, room);
		blindMode(gc, room);
	}
	
	public static void shadowMode(GraphicsContext gc, Room room)
	{
		if(!graphics.getDisplayShadowMode().getCurrentValue())
			return;
		Player player = room.getPlayer();
		List<Obstacle> obstacles = room.getObstacles();
		gc.save();
		gc.setFill(Color.rgb(0, 0, 0, .99));
		for(Obstacle obs: obstacles)
		{
			if(obs instanceof Shop)
				continue;
			double[] point1 = obs.getPoint1();
			double[] point2 = obs.getPoint2();
			double[] point3 = obs.getPoint3();
			double[] point4 = obs.getPoint4();
			double point1Angle = MyMath.findAngleBetween(player.getXCenter(), player.getYCenter(), point1[0], point1[1]);
			double point2Angle = MyMath.findAngleBetween(player.getXCenter(), player.getYCenter(), point2[0], point2[1]);
			double point3Angle = MyMath.findAngleBetween(player.getXCenter(), player.getYCenter(), point3[0], point3[1]);
			double point4Angle = MyMath.findAngleBetween(player.getXCenter(), player.getYCenter(), point4[0], point4[1]);
			double maxAngle = MyMath.findMaxValue(point1Angle, point2Angle, point3Angle, point4Angle);
			double minAngle = MyMath.findMinValue(point1Angle, point2Angle, point3Angle, point4Angle);
			double[] minPoint = null;
			double[] maxPoint = null;
			
			double superMaxAngle = Double.MIN_VALUE;
			if(superMaxAngle < makeAcute(Math.abs(point1Angle - point2Angle)))
			{
				superMaxAngle = makeAcute(Math.abs(point1Angle - point2Angle));
				minPoint = point1;
				maxPoint = point2;
			}
			if(superMaxAngle < makeAcute(Math.abs(point2Angle - point3Angle)))
			{
				superMaxAngle = makeAcute(Math.abs(point2Angle - point3Angle));
				minPoint = point2;
				maxPoint = point3;
			}
			if(superMaxAngle < makeAcute(Math.abs(point3Angle - point4Angle)))
			{
				superMaxAngle = makeAcute(Math.abs(point3Angle - point4Angle));
				minPoint = point3;
				maxPoint = point4;
			}
			if(superMaxAngle < makeAcute(Math.abs(point4Angle - point1Angle)))
			{
				superMaxAngle = makeAcute(Math.abs(point4Angle - point1Angle));
				minPoint = point4;
				maxPoint = point1;
			}
			if(superMaxAngle < makeAcute(Math.abs(point1Angle - point3Angle)))
			{
				superMaxAngle = makeAcute(Math.abs(point1Angle - point3Angle));
				minPoint = point1;
				maxPoint = point3;
			}
			if(superMaxAngle < makeAcute(Math.abs(point2Angle - point4Angle)))
			{
				superMaxAngle = makeAcute(Math.abs(point2Angle - point4Angle));
				minPoint = point2;
				maxPoint = point4;
			}
			
			double[] maxPoint2 = new double[2];
			double[] minPoint2 = new double[2];
			maxPoint2[0] = (maxPoint[0] - player.getXCenter()) * 10000;
			maxPoint2[1] = (maxPoint[1] - player.getYCenter()) * 10000;
			minPoint2[0] = (minPoint[0] - player.getXCenter()) * 10000;
			minPoint2[1] = (minPoint[1] - player.getYCenter()) * 10000;
			double[] xValues = {maxPoint[0], maxPoint2[0], minPoint2[0], minPoint[0]};
			double[] yValues = {maxPoint[1], maxPoint2[1], minPoint2[1], minPoint[1]};
			
			gc.fillPolygon(xValues, yValues, 4);
		}
		gc.restore();
	}
	
	private static double makeAcute(double angle)
	{
		if(angle > 180)
			return 360 - angle;
		return angle;
	}
	
	public static void blindMode(GraphicsContext gc, Room room)
	{
		if(!graphics.getDisplayBlindMode().getCurrentValue())
			return;
		gc.save();
		//long timeNow = System.nanoTime();
		double radius = 200;
		double lineWidth = 2000;
		double radiusRecalculated = lineWidth + radius * 2;
		double opacity = 1;
		int shadeCount = 20;
		while(shadeCount > 0)
		{
			gc.setStroke(Color.rgb(0, 0, 0, opacity));
			gc.setLineWidth(lineWidth);
			gc.strokeOval(room.getPlayer().getXCenter() - (radiusRecalculated / 2), room.getPlayer().getYCenter() - (radiusRecalculated / 2), radiusRecalculated, radiusRecalculated);
			radiusRecalculated -= 5;
			opacity -= 0.05;
			shadeCount--;
		}
		//System.out.println(System.nanoTime() - timeNow);
		gc.restore();
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
				if(tile instanceof Teleporter && !((Teleporter) tile).isActivated())
				{
						
						gc.save();
						gc.setFill(Color.rgb(0, 0, 0, .8));
						gc.fillRect(tile.getXLocation(), tile.getYLocation(), tile.getWidth(), tile.getHeight());
						gc.restore();
				}
				if(tile instanceof Teleporter && ((Teleporter)tile).getCurrentTeleTime() > 0 &&((Teleporter) tile).isActivated())
				{
						
						gc.save();
//						gc.setFill(Color.WHITE);
//						gc.setStroke(Color.BLACK);
//						gc.setFont(new Font(24));
//						gc.fillText(String.format("%.2f", ((Teleporter)tile).getCurrentTeleTime()), tile.getXLocation(), tile.getYLocation() + tile.getHeight());
//						gc.strokeText(String.format("%.2f", ((Teleporter)tile).getCurrentTeleTime()), tile.getXLocation(), tile.getYLocation() + tile.getHeight());
						gc.setFill(Color.rgb(0, 0, 0, .5));
						gc.fillRect(tile.getXLocation(), tile.getYLocation(), tile.getWidth() * (((Teleporter)tile).getCurrentTeleTime() / ((Teleporter)tile).getDefaultTeleTime()), tile.getHeight());
						gc.restore();
				}
//				if(tile instanceof Teleporter)
//				{
//					System.out.println(((Teleporter) tile).isActivated());
//				}
//				if(tile instanceof Teleporter && ((Teleporter) tile).isBossTele() && !GameRunner.getGameManager().getLevel().allDead())
//				{
//						gc.save();
//						gc.setFill(Color.rgb(0, 0, 0, .8));
//						gc.fillRect(tile.getXLocation(), tile.getYLocation(), tile.getWidth(), tile.getHeight());
//						gc.restore();
//				}
			}
		}
	}
	
	public static void drawObstacles(GraphicsContext gc, Room room)
	{
		if(graphics.getDisplayObstacleShadow().getCurrentValue())
		{
			int shadowLength = 10;
			gc.save();
			gc.setFill(Color.rgb(0, 0, 0, .3));
			for(Obstacle obs : room.getObstacles())
			{
				if(obs instanceof StoneWall)
				{
					double[] xPoints = {obs.getXLocation()   , obs.getXLocationMax(), obs.getXLocationMax(), obs.getXLocationMax() + shadowLength, obs.getXLocationMax() + shadowLength, obs.getXLocation() + shadowLength};
					double[] yPoints = {obs.getYLocationMax(), obs.getYLocationMax(), obs.getYLocation()   , obs.getYLocation() + shadowLength   , obs.getYLocationMax() + shadowLength, obs.getYLocationMax() + shadowLength};
					gc.fillPolygon(xPoints, yPoints, 6);
				}
			}
		}
		gc.setFont(new Font(50));
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		for(Obstacle obs : room.getObstacles())
		{
			for(double x = obs.getXLocation(); x < obs.getXLocation() + obs.getWidth(); x += 100)
			{
				for(double y = obs.getYLocation(); y < obs.getYLocation() + obs.getHeight(); y += 100)
				{
					gc.drawImage(obs.getSpriteImage(), x, y, 100, 100);
					if(obs instanceof Shop && ((Shop)obs).getOnSale()!=null)
					{
						gc.drawImage(((Shop)obs).getOnSale().getSpriteImage(), obs.getXCenter()-((Shop)obs).getOnSale().getWidth()/2, y,((Shop)obs).getOnSale().getWidth(),((Shop)obs).getOnSale().getHeight());
						gc.fillText(((Shop)obs).getOnSale().getCost() + "G ", obs.getXLocation(), obs.getYLocationMax(), obs.getWidth());
						gc.strokeText(((Shop)obs).getOnSale().getCost() + "G ", obs.getXLocation(), obs.getYLocationMax(), obs.getWidth());
					}
				}
			}
			//gc.drawImage(obs.getSpriteImage(), obs.getXLocation(), obs.getYLocation(), obs.getWidth(), obs.getHeight());
		}
		gc.restore();
	}
	
	public static void drawCharacters(GraphicsContext gc, Room room)
	{
		if(graphics.getDisplayCharacterShadow().getCurrentValue())
		{
			gc.save();
			gc.setFill(Color.rgb(0, 0, 0, .3));
			for(Character character : room.getCharacters())
			{
				gc.fillOval(character.getXLocation(), character.getYLocation() + character.getHeight() - 10, character.getWidth(), 20);
			}
			gc.restore();
		}
		gc.save();
		for(Character character : room.getCharacters())
		{
			rotateGC(gc, character.getFaceAngle(), character.getXLocation() + character.getWidth() / 2, character.getYLocation() + character.getHeight() / 2);
			gc.drawImage(character.getSpriteImage(), character.getXLocation(), character.getYLocation());
			drawCharacterHoldItem(gc, character);
		}
		gc.restore();
		for(Character character : room.getCharacters())
		{
			//drawCharacterActiveEffects(gc, character);
			if(character instanceof Enemy)
			{
				drawEnemyHealthBar(gc, (Enemy)character);
			}
		}	
		if(graphics.getDisplayCharacterNames().getCurrentValue())
		{
			gc.save();
			gc.setFont(new Font("arial", 16));
			gc.setFill(Color.BLACK);
			for(Character character : room.getCharacters())
			{
				gc.fillText(character.getSpriteName(), character.getXLocation(), character.getYLocation() - 12, character.getWidth());
			}
			gc.restore();
		}
		if(graphics.getDisplayCharacterEffects().getCurrentValue())
		{
			gc.save();
			for(Character character : room.getCharacters())
			{
				double dmgMulti = character.getEffectManager().getDamageMultiplier();
				if(dmgMulti > 1)
				{
					gc.setFill(Color.RED);
					gc.fillRect(character.getXLocation() - 6, character.getYLocation(), 6, 6);
				}
				if(dmgMulti < 1)
				{
					gc.setFill(Color.GRAY);
					gc.fillRect(character.getXLocation() - 6, character.getYLocation(), 6, 6);
				}
				double speedMult = character.getEffectManager().getSpeedMultiplier();
				if(speedMult > 1)
				{
					gc.setFill(Color.BLUE);
					gc.fillRect(character.getXLocation() - 6, character.getYLocation() + 7, 6, 6);
				}
				if(speedMult < 1)
				{
					gc.setFill(Color.BROWN);
					gc.fillRect(character.getXLocation() - 6, character.getYLocation() + 7, 6, 6);
				}
			}
			gc.restore();
		}
	}
	
	private static void drawCharacterActiveEffects(GraphicsContext gc, Character character)
	{
		gc.save();
		if(character.getEffectManager().getDamageMultiplier() > 1)
		{
			gc.setFill(Color.RED);
			gc.fillOval(character.getXLocation(), character.getYLocation() - 16, 5, 5);
		}
		else if(character.getEffectManager().getDamageMultiplier() < 1)
		{
			gc.setFill(Color.DARKRED);
			gc.fillOval(character.getXLocation(), character.getYLocation() - 16, 5, 5);
		}	
		if(character.getEffectManager().getSpeedMultiplier() > 1)
		{
			gc.setFill(Color.BLUE);
			gc.fillOval(character.getXLocation() + 6, character.getYLocation() - 16, 5, 5);
		}
		else if(character.getEffectManager().getSpeedMultiplier() < 1)
		{
			gc.setFill(Color.DARKBLUE);
			gc.fillOval(character.getXLocation() + 6, character.getYLocation() - 16, 5, 5);
		}
		gc.restore();
	}
	
	private static void drawEnemyHealthBar(GraphicsContext gc, Enemy enemy)
	{
		HealthBar.drawHealthBar(gc, enemy.getXLocation() - 5, enemy.getYLocation() - 10, enemy.getHealthbar());
	}
	
	private static void drawCharacterHoldItem(GraphicsContext gc, Character character)
	{
		if(character.isGunVisibility())
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
	}
	
	public static void drawItems(GraphicsContext gc, Room room)
	{
		if(graphics.getDisplayItemShadow().getCurrentValue())
		{
			gc.save();
			gc.setFill(Color.rgb(0, 0, 0, .3));
			for(Item item : room.getItems())
			{
				gc.fillOval(item.getXLocation(), item.getYLocation() + item.getHeight() - 10, item.getWidth(), 20);
			}
			gc.restore();
		}
		for(Item item : room.getItems())
		{
			if(graphics.getDisplayItemRotating().getCurrentValue())
			{
				gc.drawImage(item.getSpriteImage(), item.getXLocation() + (Math.sin((timePassed / 1000.0) + Math.PI) * item.getWidth() / 2) + (item.getWidth() / 2), item.getYLocation() + (Math.cos((timePassed / 1000.0)) * 10), Math.sin((timePassed / 1000.0)) * item.getSpriteImage().getWidth(), item.getHeight());
			}
			else
			{
				gc.drawImage(item.getSpriteImage(), item.getXLocation(), item.getYLocation());
			}
			
		}
		if(graphics.getDisplayItemNames().getCurrentValue())
		{
			gc.save();
			gc.setFont(new Font("arial", 16));
			gc.setFill(Color.BLACK);
			for(Item item : room.getItems())
			{
				gc.fillText(item.getSpriteName(), item.getXLocation() - 3, item.getYLocation() - 5, item.getWidth() + 6);
			}
			gc.restore();
		}
		
	}
	
	public static void drawProjectiles(GraphicsContext gc, Room room)
	{
		gc.save();
		for(Projectile pro : room.getProjectiles())
		{
			//System.out.println(pro);
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
