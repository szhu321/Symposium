package sprite.character.effect;

import sprite.character.Character;
public abstract class Effect
{
	private EffectManager thisManager;
	
	public Effect(EffectManager manager)
	{
		thisManager = manager;
	}
	
	public Effect()
	{
		
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
	
	public abstract boolean applyEffect(Character character);
}
