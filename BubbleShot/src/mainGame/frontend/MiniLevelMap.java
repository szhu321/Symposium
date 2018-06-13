package mainGame.frontend;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import map.Level;
import map.Room;
import myutilities.StaticImage;

public class MiniLevelMap
{
	private static int boxSize = 20;
	private static int boxGap = 10;
	
	private static int startX = 10;
	private static int startY = 10;
	
	private static void fillBackground(GraphicsContext gc)
	{
		gc.setFill(Color.rgb(0, 0, 0, 0.5));
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}
	
	public static void drawMiniMap(GraphicsContext gc, Level level)
	{
		fillBackground(gc);
		fillLevelRec(gc, level);
	}
	
	public static void fillLevelRec(GraphicsContext gc, Level level)
	{
		Room[][] rooms = level.getMap();
		int row = level.getCurrentRoom().getLevelRow();
		int col = level.getCurrentRoom().getLevelCol();
		if(row > 0)
			row--;
		if(col > 0)
			col--;
		for(int i = row, y = 10; i < rooms.length; i++, y += 40)
		{
			for(int j = col, x = 10; j < rooms[i].length; j++, x += 40)
			{
				if(rooms[i][j] != null)
				{
					if(rooms[i][j].isExplored())
					{
						gc.setFill(Color.GREEN);
						gc.fillRect(x, y, 20, 20);
					}	
					else
					{
						gc.setFill(Color.WHITE);
						gc.fillRect(x, y, 20, 20);
						if(rooms[i][j].isBossRoom())
						{
							gc.setFill(Color.RED);
							gc.fillRect(x, y, 20, 20);
						}
					}
					if(rooms[i][j] == level.getCurrentRoom() && (System.currentTimeMillis() % 2000) > 1000)
					{
						gc.setFill(Color.YELLOW);
						gc.fillRect(x, y, 20, 20);
					}
					if(rooms[i][j].isShopRoom())
					{
						gc.drawImage(StaticImage.SHOP_IMAGE, x, y, 20, 20);
					}
					if(rooms[i][j].isBossRoom())
					{
						gc.drawImage(StaticImage.ROBO_BOSS_IMAGE, x, y, 20, 20);
					}
				}
			}
		}
	}
	
}
