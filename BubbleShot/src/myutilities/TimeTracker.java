package myutilities;

public class TimeTracker
{
	private static long storedTime = System.currentTimeMillis();
	
	public static void resetTime()
	{
		storedTime = System.currentTimeMillis();
	}
	
	/**
	 * 
	 * @return The time passed since the last call to resetTime or getTimePassed in seconds.
	 */
	public static double getTimePassed()
	{
		double timePassed = (System.currentTimeMillis() - storedTime) / 1000;
		storedTime = System.currentTimeMillis();
		return timePassed;
	}
}
