package map.Tile.teleporter;

import java.util.ArrayList;
import java.util.List;

public class LevelPortManager
{
	private List<TeleporterPair> teleporterPair;
	
	public LevelPortManager()
	{
		teleporterPair = new ArrayList<TeleporterPair>();
	}

	public List<TeleporterPair> getTeleporterPair()
	{
		return teleporterPair;
	}

	public void setTeleporterPair(List<TeleporterPair> teleporterPair)
	{
		this.teleporterPair = teleporterPair;
	}
	
}
