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
	
	public static final double TELEPORT_TIME = 2;
	private double defaultTime;
	private double currentTime;
	
	
	public Teleporter(double xPos, double yPos, int id,String filename)
	{	
		super("Teleporter", filename, xPos, yPos, 100, 100, 0);
		this.id=id;
		activated = false;
	}
	
	/**
	 * Runs the timer down by a specified amount of time.
	 * @param sec The time the timer decreases by.
	 * @return If the timer is 0 or less return true. false otherwise.
	 */
	public boolean runTimer(double sec)
	{
		if(defaultTime == 0)
		{
			setTimer();
			return false;
		}
		currentTime -= sec;
		if(currentTime <= 0)
		{
			resetTimer();
			return true;
		}
		return false;
	}
	
	public void resetTimer()
	{
		currentTime = 0;
		defaultTime = 0;
	}
	
	public void setTimer()
	{
		currentTime = TELEPORT_TIME;
		defaultTime = TELEPORT_TIME;
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
	
	public double getDefaultTeleTime()
	{
		return defaultTime;
	}
	
	public double getCurrentTeleTime()
	{
		return currentTime;
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
