package sprite.character.effect;

import sprite.character.Character;

public abstract class HealthEffect extends Effect
{
	private double effectTime;
	private int effectAmount;
	
	public HealthEffect(double effectTime, int effectAmount)
	{
		this.effectTime = effectTime;
		this.setEffectAmount(effectAmount);
	}
	
	public void setEffectTime(double time){effectTime = time;}
	public double getEffectTime() {return effectTime;}
	public int getEffectAmount() {return effectAmount;}
	public void setEffectAmount(int effectAmount) {this.effectAmount = effectAmount;}
	
	public abstract boolean applyEffect(Character character);
}
