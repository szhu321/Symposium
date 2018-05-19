package map.Tile.teleporter;

import map.Room;
import map.Tile.Tile;

public class Teleporter extends Tile
{
	private Room connectedRoom;
	private Teleporter connectedTeleporter;
	private boolean activated;
	private boolean bossTele=false;
	private boolean wasUsed=false;
	private boolean playerOn=false;
	private int id;
	
	public Teleporter(double xPos, double yPos, int id,String filename)
	{	
		super("Teleporter", filename, xPos, yPos, 100, 100, 0);
		this.id=id;
		activated = false;
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
	}
	
	public String toString()
	{
		return "Name: " + getSpriteName() + ". Activation: " + activated + ". RoomName: " + connectedRoom.getName() + ". ConnectedTeleporter: " + connectedTeleporter.getSpriteName();
	}

	public boolean isActivated() {return activated;}
	public void setActivated(boolean activated) {this.activated = activated;}

	/**
	 * @return the bossTele
	 */
	public boolean isBossTele() {
		return bossTele;
	}

	/**
	 * @param bossTele the bossTele to set
	 */
	public void setBossTele(boolean bossTele) 
	{
		this.bossTele = bossTele;
	}

	public boolean isWasUsed() {
		return wasUsed;
	}

	public void setWasUsed(boolean wasUsed) {
		this.wasUsed = wasUsed;
	}

	public boolean isPlayerOn() {
		return playerOn;
	}

	public void setPlayerOn(boolean playerOn) {
		this.playerOn = playerOn;
	}
}
