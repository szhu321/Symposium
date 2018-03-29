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
		StatItem<Integer> scoreStat = new StatItem<Integer>("Your Score", 0);
		playerStats.addStats(scoreStat);
	}
	
	
	public StatsViewer playerStats(){return playerStats;}
}
