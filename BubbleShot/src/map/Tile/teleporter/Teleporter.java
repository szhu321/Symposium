package map.Tile.teleporter;

import map.Room;
import map.Tile.Tile;

public class Teleporter extends Tile
{
	private Room connectedRoom;
	private Teleporter connectedTeleporter;
	private boolean activated;
	private int id;
	
	public Teleporter(double xPos, double yPos, int id)
	{
		
		super("Teleporter", "file:resources/tile/teleporttile.png", xPos, yPos, 100, 100, 0);
		activated = true;
	}

	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
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
		return "Name: " + getSpriteName() + ". Activation: " + activated + ". RoomName: " + connectedRoom.getName() + ". ConnectedTeleporter: " + connectedTeleporter.getSpriteName();
	}

	public boolean isActivated() {return activated;}
	public void setActivated(boolean activated) {this.activated = activated;}
}
