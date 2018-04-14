package map;

import sprite.character.player.Player;

public class Level
{
	private Room[][] map;
	private Room currentRoom;
	
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
	public void setCurrentRoom(int row, int col) {currentRoom = map[row][col];}
	
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
