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
}
