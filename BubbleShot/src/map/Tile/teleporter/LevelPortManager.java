package map.Tile.teleporter;

import java.util.ArrayList;
import java.util.List;

public class LevelPortManager
{
	private List<RoomPortManager> levelPorters;
	
	public LevelPortManager()
	{
		setLevelPorters(new ArrayList<RoomPortManager>());
	}

	public List<RoomPortManager> getLevelPorters() {return levelPorters;}
	public void setLevelPorters(List<RoomPortManager> levelPorters) {this.levelPorters = levelPorters;}
}
