package mainGame.frontend;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import map.Level;
import map.Room;

public class MiniLevelMap
{
	
	private static void fillBackground(GraphicsContext gc)
	{
		gc.setFill(Color.BLACK);
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
		for(int i = 0, y = 10; i < rooms.length; i++, y += 40)
		{
			for(int j = 0, x = 10; j < rooms[i].length; j++, x += 40)
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
					}
					if(rooms[i][j] == level.getCurrentRoom() && (System.currentTimeMillis() % 2000) > 1000)
					{
						gc.setFill(Color.YELLOW);
						gc.fillRect(x, y, 20, 20);
					}
				}
			}
		}
	}
	
}
