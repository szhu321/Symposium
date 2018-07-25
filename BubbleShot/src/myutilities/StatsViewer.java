package myutilities;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that keeps track of all the stats of the player.
 */
public class StatsViewer
{
	public List<StatItem> stats;
	
	public StatsViewer()
	{
		stats = new ArrayList<StatItem>();
	}
	
	public void addStats(int idx, StatItem stat)
	{
		stats.add(idx, stat);
	}
	
	public void addStats(StatItem stat)
	{
		stats.add(stat);
	}
	
	public List<StatItem> getStats() {return stats;}
	
	public String toString()
	{
		String result = "";
		for(StatItem stat: stats)
			result += stat.toString() + "\n";
		return result;
	}
}
