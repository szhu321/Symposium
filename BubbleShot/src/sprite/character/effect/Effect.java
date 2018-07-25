package sprite.character.effect;

import java.io.Serializable;

import sprite.character.Character;
public abstract class Effect implements Serializable
{
	private static final long serialVersionUID = -2002040933882600222L;
	
	private EffectManager thisManager;
	private double defaultEffectTime;
	private double effectTime;
	private double effectAmount;
	private boolean active;
	private boolean instantaneous;

	public Effect(double effectTime, double effectAmount, boolean instantaneous)
	{
		this.effectTime = effectTime;
		this.effectAmount = effectAmount;
		defaultEffectTime = effectTime;
		this.instantaneous = instantaneous;
		active = true;
		//System.out.println("DWAFAWFAW" + defaultEffectTime);
	}
	
	public void setManager(EffectManager manager)
	{
		thisManager = manager;
	}
	
	public EffectManager getThisManager() {return thisManager;}
	
	public void setEffectTime(double time)
	{
		effectTime = time;
		if(effectTime <= 0)
		{
			active = false;
			effectTime = 0;
			return;
		}	
	}
	
	public double getEffectTime() {return effectTime;}
	public double getEffectAmount() {return effectAmount;}
	public void setEffectAmount(int effectAmount) {this.effectAmount = effectAmount;}
	public double getDefaultEffectTime() {return defaultEffectTime;}

	
	public boolean isActive()
	{
		return active;
	}
	
	public void setActive(boolean boo)
	{
		active = boo;
	}
	
	public boolean isInstantaneous() 
	{
		return instantaneous;
	}

	public abstract boolean applyEffect(Character character, double sec);
	
	public String toString()
	{
		String result = "Class: " + this.getClass().getSimpleName() + "\n"
				+ "Default Effect Time: " + defaultEffectTime + "\n"
				+ "Effect Time: " + effectTime + "\n" 
				+ "Effect Amount: " + effectAmount + "\n"
				+ "Is active: " + active + "\n";
		return result;
	}
}
