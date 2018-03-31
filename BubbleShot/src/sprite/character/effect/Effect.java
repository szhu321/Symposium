package sprite.character.effect;

import sprite.character.Character;
public abstract class Effect
{
	private EffectManager thisManager;
	private double effectTime;
	private double effectAmount;

	public Effect(EffectManager manager, double effectTime, int effectAmount, boolean instantaneous)
	{
		thisManager = manager;
		this.effectTime = effectTime;
		this.effectAmount = effectAmount;
		if(instantaneous)
			applyEffect(thisManager.getCharacter());
			
	}
	
	public Effect(double effectTime, int effectAmount, boolean instantaneous)
	{
		this.effectTime = effectTime;
		this.effectAmount = effectAmount;
		if(instantaneous)
			applyEffect(thisManager.getCharacter());
	}
	
	public void setManager(EffectManager manager)
	{
		thisManager = manager;
	}
	
	public EffectManager getThisManager() {return thisManager;}
	
	public void removeEffect()
	{
		thisManager.removeEffect(this);
	}
	
	public void setEffectTime(double time)
	{
		if(effectTime <= 0)
		{
			removeEffect();
			return;
		}	
		effectTime = time;
	}
	public double getEffectTime() {return effectTime;}
	public double getEffectAmount() {return effectAmount;}
	public void setEffectAmount(int effectAmount) {this.effectAmount = effectAmount;}
	
	public abstract boolean applyEffect(Character character);
}
