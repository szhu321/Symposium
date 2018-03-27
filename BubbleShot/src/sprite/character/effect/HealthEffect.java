package sprite.character.effect;

import sprite.character.Character;

public abstract class HealthEffect extends Effect
{
	private double effectTime;
	private int effectAmount;
	private Thread timer;
	
	public HealthEffect(double effectTime, int effectAmount)
	{
		this.effectTime = effectTime;
		this.setEffectAmount(effectAmount);
		timer = new Thread()
		{
			public void run()
			{
				applyEffect(getThisManager().getCharacter());
			}
		};
	}
	
	public void setEffectTime(double time){effectTime = time;}
	public double getEffectTime() {return effectTime;}
	public int getEffectAmount() {return effectAmount;}
	public void setEffectAmount(int effectAmount) 
	{
		if(effectAmount <= 0)
			removeEffect();
		this.effectAmount = effectAmount;
	}
	
	public abstract boolean applyEffect(Character character);
}
