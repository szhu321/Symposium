package mainGame.backend;

import map.Level;
import sprite.character.player.Player;

public class GameManager
{
	private Level level;
	private Player player;
	
	public GameManager(Level level, Player player)
	{
		this.level = level;
		this.player = player;
	}
	
	public void startGame()
	{
		
	}
	
	/**
	 * Runs the next frame;
	 * @param second - the time passed since the last frame.
	 */
	public void nextFrame(double second)
	{
		
	}
	
	public void pauseGame()
	{
		
	}
	
	public void unPauseGame()
	{
		
	}
	
	
}
