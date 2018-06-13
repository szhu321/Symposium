package sprite.character.effect;

import sprite.character.Character;

public class NoEffect extends Effect
{
	public static final NoEffect NO_EFFECT = new NoEffect();
	
	public NoEffect() 
	{
		super(100,0,false);
	}

	@Override
	public boolean applyEffect(Character character, double sec)
	{
		return false;
	}

}
