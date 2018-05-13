package map.Tile.teleporter;

import java.util.ArrayList;
import java.util.List;

public class RoomPortManager
{
	private List<Teleporter> roomPorters;
	
	public RoomPortManager()
	{
		setRoomPorters(new ArrayList<Teleporter>());
	}

	public List<Teleporter> getRoomPorters() {return roomPorters;}
	public void setRoomPorters(List<Teleporter> roomPorters) {this.roomPorters = roomPorters;}
	
	public void addTeleporter(Teleporter tele)
	{
		roomPorters.add(tele);
	}
	
	public void removeTeleporter(Teleporter tele)
	{
		roomPorters.remove(tele);
	}
	
	public void activateAllTeleporters()
	{
		for(Teleporter tele : roomPorters)
		{
			tele.setActivated(true);
		}
	}
	
	public void activateTeleporter(Teleporter tele)
	{
		tele.setActivated(true);
	}
	
	public void deactivateAllTelePorters()
	{
		for(Teleporter tele : roomPorters)
		{
			tele.setActivated(false);
		}
	}
	
	public void deactivateTeleporter(Teleporter tele)
	{
		tele.setActivated(false);
	}
}
