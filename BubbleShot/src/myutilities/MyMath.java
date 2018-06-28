package myutilities;

public class MyMath
{
	/**
	 * Random int generator
	 * @param min The minimum value
	 * @param max The maximun value
	 * @return random ints between min and max inclusive.
	 */
	public static int getRandomInteger(int min, int max)
	{
		return (int)(Math.random() * (max - min + 1)) + min;
	}
	
	/**
	 * rounds a positive integer to a certain amount of places.
	 * @param num - a positive integer to be rounded
	 * @param zeros - number of zero to round to. this number has to be 1 or greater.
	 * Ex. 1 would be round to the nearest 10, 2 would be 100, 3 would be 1000, etc.
	 * @return the rounded number.
	 */
	public static int round(double num, int zeros)
	{
		if(zeros < 1 || num < 0)
			return -1;
		int rounder = (int)Math.pow(10, zeros);
		double remainder = num % rounder;
		if(remainder >= rounder / 2)
			return ((int)num / rounder) * rounder + rounder;
		return ((int)num / rounder) * rounder;
	}
	
	/**
	 * Finds the distance between two points.
	 * @param x1 x coordinate of the first point.
	 * @param y1 y coordinate of the first point.
	 * @param x2 x coordinate of the second point.
	 * @param y2 y coordinate of the second point.
	 * @return The distance between the two points.
	 */
	public static double distanceBetween(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	/**
	 * Finds the angle between the horizontal line of point 1 to the 
	 * line that connects points 1 and point 2. Angle increases counterclockwise.
	 * @param x1 x coordinate of the first point.
	 * @param y1 y coordinate of the first point.
	 * @param x2 x coordinate of the second point.
	 * @param y2 y coordinate of the second point.
	 * @return The angle in degree of the 2 points.
	 */
	public static double findAngleBetween(double x1, double y1, double x2, double y2)
	{
		double distanceX = x2 - x1;
		double distanceY = y2 - y1;
		double angle = Math.toDegrees(Math.atan(distanceY / distanceX));
		if(distanceY <= 0 && distanceX < 0)
			angle += 180;
		else if(distanceY > 0 && distanceX < 0)
			angle = 90 + (90 - Math.abs(angle));
		else if(distanceX > 0 && distanceY < 0)
			angle += 360;
		return angle;
	}
	
	/**
	 * Find the max number given a set of numbers. Ex. findMaxValue(5, 10, 4) returns 10.
	 * @param nums An certain amount of numbers. 
	 * @return the max num in a set of numbers
	 */
	public static double findMaxValue(double... nums)
	{
		double max = Double.MIN_VALUE;
		for(double num : nums)
		{
			if(max < num)
				max = num;
		}
		return max;
	}
	
	/**
	 * Find the min number given a set of numbers. Ex. findMinValue(5, 10, 4) returns 4.
	 * @param nums An certain amount of numbers. 
	 * @return the min number in a set of numbers
	 */
	public static double findMinValue(double... nums)
	{
		double min = Double.MAX_VALUE;
		for(double num : nums)
		{
			if(min > num)
				min = num;
		}
		return min;
	}
	
	/**
	 * Finds a new point given a point rotated counterclockwise along a pivot.
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param centerX The x pivot
	 * @param centerY The y pivot
	 * @param degrees The degree rotated counterclockwise
	 * @return the new point after rotation.
	 */
	public static double[] rotatePointAboutPivot(double x, double y, double centerX, double centerY, double degrees)
	{
		double[] result = new double[2];
		//x' = xcos() - ysin()
		result[0] = (x * Math.cos(Math.toRadians(degrees))) - (y * Math.sin(Math.toRadians(degrees)));
		//y' = ycos() + xsin()
		result[1] = (y * Math.cos(Math.toRadians(degrees))) + (x * Math.sin(Math.toRadians(degrees)));
		//Translate based on povit.
		result[0] = result[0] + centerX;
		result[1] = result[1] + centerY;
		return result;
	}
	
	
}
