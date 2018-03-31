package sprite.character.effect;

import sprite.character.Character;

public class NoEffect extends Effect
{

	public NoEffect() 
	{
		super(100,0,false);
	}

	@Override
	public boolean applyEffect(Character character)
	{
		return false;
	}

}
