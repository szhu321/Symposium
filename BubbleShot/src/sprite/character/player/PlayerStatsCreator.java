package sprite.character.player;

import myutilities.StatItem;
import myutilities.StatsViewer;

public class PlayerStatsCreator
{
	private StatsViewer playerStats;
	
	public PlayerStatsCreator()
	{
		playerStats = new StatsViewer();
		addScoreInformation();
	}
	
	public void addScoreInformation()
	{
		playerStats.addStats(new StatItem<Integer>("Name: ", 0));
		playerStats.addStats(new StatItem<Integer>("Your Score", 0));
		playerStats.addStats(new StatItem<Integer>("Death Count: ", 0));
		playerStats.addStats(new StatItem<Integer>("Enemies Killed: ", 0));
		playerStats.addStats(new StatItem<Integer>("Max Health: ", 0));
	}
	
	
	public StatsViewer playerStats(){return playerStats;}
}
