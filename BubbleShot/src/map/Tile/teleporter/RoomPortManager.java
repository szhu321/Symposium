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
}
