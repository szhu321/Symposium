package myutilities;

import java.util.ArrayList;
import java.util.List;

public class PlayerStats
{
	public List<StatItem> stats;
	
	public PlayerStats()
	{
		stats = new ArrayList<StatItem>();
	}
	
	public List<StatItem> getStats() {return stats;}
	
}
