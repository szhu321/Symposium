package map;

import java.io.Serializable;

import map.Tile.Tile;
import map.Tile.teleporter.LevelPortManager;
import map.Tile.teleporter.Teleporter;
import map.Tile.teleporter.TeleporterDesign;
import map.Tile.teleporter.TeleporterPair;
import sprite.character.player.Player;

public class Level implements Serializable
{
	private static final long serialVersionUID = -7920860956185670599L;
	
	private Room[][] map;
	private Room currentRoom;
	
	private LevelPortManager allTeleporters = new LevelPortManager();
	/**
	 * Creates a level with specified row(height) and col(width) of rooms.
	 * @param width > 0
	 * @param height > 0
	 */
	public Level(int width, int height)
	{
		map = new Room[height][width];
	}
	
	/**
	 * Increases the map size by a certain width and height.
	 * @param width The increase in width.
	 * @param height The increase in height.
	 */
	public void incMapSize(int width, int height)
	{
		int currentWidth = map[0].length;
		int currentHeight = map.length;
		
		Room[][] tempRoom = new Room[currentHeight + height][currentWidth + width];
		for(int row = 0; row < map.length; row++)
			for(int col = 0; col < map[0].length; col++)
				tempRoom[row][col] = map[row][col];
		map = tempRoom;
	}
	
	/**
	 * Adds a room to the specified row and column.
	 * @param room The room that is getting added.
	 * @param row The row to add the room to.
	 * @param col The col to add the room to.
	 * @return true if the room was successfully added, false otherwise.
	 */
	public boolean addRoomTo(Room room, int row, int col)
	{
		if(map[row][col] != null)
			return false;
		map[row][col] = room;
		room.setLevelCol(col);
		room.setLevelRow(row);
		return true;
	}
	
	public boolean addNullRoomTo(Room room, int row, int col)
	{
		map[row][col] = room;
		return true;
	}
	/**
	 * Removes a room from a specified row and col.
	 * @param row The row to remove the room from.
	 * @param col The column to remove the room from.
	 * @return The room that was removed.
	 */
	public Room removeRoomFrom(int row, int col)
	{
		Room room = map[row][col];
		room.setLevelCol(0);
		room.setLevelRow(0);
		map[row][col] = null;
		return room;
	}
	
	/**
	 * Finds the row of a certain room.
	 * @param room The room that you wish to find the row of.
	 * @return The row of the room passed in. If the room is not in the level return -1;
	 */
	public int getRowOfRoom(Room room)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] != null && map[i][j].equals(room))
					return i;
			}
		}
		return -1;
	}
	
	/**
	 * Finds the column of a certain room.
	 * @param room The room that you wish to find the column of.
	 * @return The column of the room passed in. If the room is not in the level return -1;
	 */
	public int getColOfRoom(Room room)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				if(map[i][j] != null && map[i][j].equals(room))
					return j;
			}
		}
		return -1;
	}
	
	public Room[][] getMap() {return map;}
	public void setMap(Room[][] map) {this.map = map;}
	public Room getCurrentRoom() {return currentRoom;}
	public void setCurrentRoom(int row, int col) 
	{
		currentRoom = map[row][col];
		currentRoom.setIsExplored(true);
	}
	
	
	public LevelPortManager getAllTeleporters() 
	{
		return allTeleporters;
	}
	
	public void setAllTeleporters(LevelPortManager allTeleporters) 
	{
		this.allTeleporters = allTeleporters;
	}

	public void placeTeleportersInLevel()
	{
		int pairCounter=0;
		for(int i=0;i<map.length;i++)
		{
			for(int s=0;s<map[0].length;s++)
			{
				if(!(s+1>=map[0].length)&&map[i][s]!=null&&map[i][s+1]!=null)
				{
					TeleporterPair currentPair=new TeleporterPair();
					Teleporter tele1=null;
					Teleporter tele2=null;
					Tile currentTile=map[i][s].getTileAt(map[i][s].getRoomPixWidth()-200, map[i][s].getRoomPixHeight()/2);
					Tile currentTile1=map[i][s+1].getTileAt(100, map[i][s+1].getRoomPixHeight()/2);
					if(map[i][s].isBossRoom()||map[i][s+1].isBossRoom())
					{
						tele1=TeleporterDesign.getBossTeleporter(currentTile.getXLocation(),currentTile.getYLocation(),pairCounter);
						tele2=TeleporterDesign.getBossTeleporter(currentTile1.getXLocation(),currentTile1.getYLocation(),pairCounter);
						tele1.setBossTele(true);
						tele2.setBossTele(true);
					}
					else
					{
						tele1=TeleporterDesign.getRegularTeleporter(currentTile.getXLocation(),currentTile.getYLocation(),pairCounter);
						tele2=TeleporterDesign.getRegularTeleporter(currentTile1.getXLocation(),currentTile1.getYLocation(),pairCounter);
					}
					tele1.setConnectedRoom(map[i][s]);					
					tele2.setConnectedRoom(map[i][s+1]);
					tele1.setConnectedTeleporter(tele2);
					tele2.setConnectedTeleporter(tele1);
					currentPair.setId(tele1.getId());
					currentPair.setTeleporter1(tele1);
					currentPair.setTeleporter1(tele2);
					
					allTeleporters.getTeleporterPair().add(currentPair);
										
					map[i][s].setTileAt((int)(tele1.getYLocation()/100), (int)(tele1.getXLocation()/100), tele1);
					map[i][s+1].setTileAt((int)(tele2.getYLocation()/100), (int)(tele2.getXLocation()/100), tele2);
					
					pairCounter++;
				}
				if(!(i+1>=map.length)&&map[i][s]!=null&&map[i+1][s]!=null)
				{
					TeleporterPair currentPair=new TeleporterPair();
					Teleporter tele1=null;
					Teleporter tele2=null;
					Tile currentTile=map[i][s].getTileAt(map[i][s].getRoomPixWidth()/2, map[i][s].getRoomPixHeight()-200);
					Tile currentTile1=map[i+1][s].getTileAt(map[i+1][s].getRoomPixWidth()/2,100);
					if(map[i][s].isBossRoom()||map[i+1][s].isBossRoom())
					{
						tele1=TeleporterDesign.getBossTeleporter(currentTile.getXLocation(),currentTile.getYLocation(), pairCounter);
						tele2=TeleporterDesign.getBossTeleporter(currentTile1.getXLocation(),currentTile1.getYLocation(), pairCounter);
						tele1.setBossTele(true);
						tele2.setBossTele(true);
					}
					else
					{
						tele1=TeleporterDesign.getRegularTeleporter(currentTile.getXLocation(),currentTile.getYLocation(), pairCounter);
						tele2=TeleporterDesign.getRegularTeleporter(currentTile1.getXLocation(),currentTile1.getYLocation(), pairCounter);
					}
					tele1.setConnectedRoom(map[i][s]);
					tele2.setConnectedRoom(map[i+1][s]);
					tele1.setConnectedTeleporter(tele2);
					tele2.setConnectedTeleporter(tele1);
					currentPair.setId(tele1.getId());
					currentPair.setTeleporter1(tele1);
					currentPair.setTeleporter1(tele2);
					
					allTeleporters.getTeleporterPair().add(currentPair);
										
					map[i][s].setTileAt((int)(tele1.getYLocation()/100), (int)(tele1.getXLocation()/100), tele1);
					map[i+1][s].setTileAt((int)(tele2.getYLocation()/100), (int)(tele2.getXLocation()/100), tele2);
					pairCounter++;
				}
			}
		}
	}
	
	public void placePlayerInCurrentRoom(Player player)
	{
		//If the currentRoom has a player don't add again.
		if(currentRoom.getCharacters().contains(player))
			return;
		currentRoom.addCharacter(player);
	}
	
	public void removePlayerFromCurrentRoom(Player player)
	{
		currentRoom.getCharacters().remove(player);
	}
	
	public boolean allDead()
	{
		int counter=map.length*map[0].length;
		for(Room[] r:map)
		{
			for(Room rs:r)
			{
				if(rs==null||rs.isBossRoom())
                {
						counter--;
						continue;
                }
				if(!rs.isEnemySpawned())
					return false;
				if(rs.isAllEnemyDead())
					counter--;
			}
		}
	//	System.out.println(counter);
		if(counter==0)
			return true;
		return false;
	}
}
