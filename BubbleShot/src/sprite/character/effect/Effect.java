package sprite.character.effect;

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
	
	public void removeEffect()
	{
		thisManager.removeEffect(this);
	}
	
	public abstract boolean applyEffect();
}
