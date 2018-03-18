package map.Tile;

/**
 * Enumeration set used for different effect values;
 * @author Sheng
 *
 */
public enum Effect
{
	NO_EFFECTS(1.0, 1.0),
	SLOW_EFFECT_LOW(.8, 1.0),
	ATTACKDOWN_EFFECT_LOW(1.0, .8),
	SLOW_EFFECT_HIGH(.5, 1.0),
	ATTACKDOWN_EFFECT_HIGH(1.0, .5);
	
	private final double percentSpeed;
	private final double percentAttack;
	
	Effect(double percentSpeed, double percentAttack)
	{
		this.percentSpeed = percentSpeed;
		this.percentAttack = percentAttack;
	}
	
	public double getSpeedPer() {return percentSpeed;}
	public double getAttackPer() {return percentAttack;}
}
