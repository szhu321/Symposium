package myutilities;

public class TimeTracker
{
	private static long storedTime = System.nanoTime();
	
	public static void resetTime()
	{
		storedTime = System.nanoTime();
	}
	
	/**
	 * 
	 * @return The time passed since the last call to resetTime or getTimePassed in milliseconds.
	 */
	public static double getTimePassed()
	{
		long timePassed = System.nanoTime() - storedTime;
		storedTime = System.nanoTime();
		return timePassed / 1000000.0;
	}
}
