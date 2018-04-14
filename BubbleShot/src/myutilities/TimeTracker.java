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
	 * @return The time passed since the last call to resetTime or getTimePassed in milliseconds.
	 */
	public static long getTimePassed()
	{
		long timePassed = System.currentTimeMillis() - storedTime;
		storedTime = System.currentTimeMillis();
		return timePassed;
	}
}
