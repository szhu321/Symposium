package map;

import map.Tile.teleporter.LevelPortManager;
import map.Tile.teleporter.Teleporter;
import map.Tile.teleporter.TeleporterDesign;
import map.Tile.teleporter.TeleporterPair;
import sprite.character.player.Player;

public class Level
{
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
	
	public boolean addRoomTo(Room room, int row, int col)
	{
		if(map[row][col] != null)
			return false;
		map[row][col] = room;
		return true;
	}
	
	public Room removeRoomFrom(int row, int col)
	{
		Room room = map[row][col];
		map[row][col] = null;
		return room;
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
					if(map[i][s].isBossRoom()||map[i][s+1].isBossRoom())
					{
						tele1=TeleporterDesign.getBossTeleporter(800,400,pairCounter);
						tele2=TeleporterDesign.getBossTeleporter(100,400,pairCounter);
					}
					else
					{
						tele1=TeleporterDesign.getRegularTeleporter(800,400,pairCounter);
						tele2=TeleporterDesign.getRegularTeleporter(100,400,pairCounter);
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
					if(map[i][s].isBossRoom()||map[i+1][s].isBossRoom())
					{
						tele1=TeleporterDesign.getBossTeleporter(400,800, pairCounter);
						tele2=TeleporterDesign.getBossTeleporter(400,100, pairCounter);
					}
					else
					{
						tele1=TeleporterDesign.getRegularTeleporter(400,800, pairCounter);
						tele2=TeleporterDesign.getRegularTeleporter(400,100, pairCounter);
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
}
