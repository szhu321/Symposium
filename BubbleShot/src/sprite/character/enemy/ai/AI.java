package sprite.character.enemy.ai;

import sprite.character.player.Player;

public abstract class AI 
{
	private Player currentPlayer;
	public AI(Player player)
	{
		currentPlayer=player;
	}
	
	public abstract void move();

}
