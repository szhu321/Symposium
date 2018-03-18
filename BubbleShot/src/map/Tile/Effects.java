package map.Tile;

/**
 * Each tile on the map will have a certain effect.
 * The effect will affect both players as well as mobs.
 * 
 * @author Sheng
 */
public class Effects
{
	// A value of 1 means there is no change in effect.
	private double speedPercent;
	private double attackPercent;
	
	/**
	 * 
	 * @param speedPer - The change in movement speed of character in percentage.
	 * @param attackPer - The change in attack damage of character in percentage.
	 */
	public Effects(double speedPer, double attackPer)
	{
		speedPercent = speedPer;
		attackPercent = attackPer;
	}
	
	/**
	 *  No effect. All values are set to one.
	 */
	public Effects()
	{
		this(1.0, 1.0);
	}
	
	public double getAttackPercent() {return attackPercent;}
	public double getSpeedPercent() {return speedPercent;}
	public void setAttackPercent(double attackPercent) {this.attackPercent = attackPercent;}
	public void setSpeedPercent(double speedPercent) {this.speedPercent = speedPercent;}
}
