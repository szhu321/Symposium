package map.Tile.teleporter;

import map.Room;
import map.Tile.Tile;

public class Teleporter extends Tile
{
	private Room connectedRoom;
	private Teleporter connectedTeleporter;
	private boolean activated;
	
	public Teleporter(String name, String fileName, Room connectedRoom)
	{
		super(name, fileName);
		this.setConnectedRoom(connectedRoom);  
		activated = true;
		connectedTeleporter = new Teleporter(fileName, fileName, connectedRoom);
		connectedTeleporter.setConnectedTeleporter(this);
	}

	public Room getConnectedRoom()
	{
		return connectedRoom;
	}

	public void setConnectedRoom(Room connectedRoom) 
	{
		this.connectedRoom = connectedRoom;
	}

	public Teleporter getConnectedTeleporter()
	{
		return connectedTeleporter;
	}

	public void setConnectedTeleporter(Teleporter connectedTeleporter)
	{
		this.connectedTeleporter = connectedTeleporter;
		this.connectedTeleporter.setConnectedTeleporter(this);
	}
	
	public String toString()
	{
		return "Name: " + getName() + ". Activation: " + activated + ". RoomName: " + connectedRoom.getName() + ". ConnectedTeleporter: " + connectedTeleporter.getName();
	}

	public boolean isActivated() {return activated;}
	public void setActivated(boolean activated) {this.activated = activated;}
}
