package sprite.character.effect;

import java.util.ArrayList;
import java.util.List;
import sprite.character.Character;

public class EffectManager 
{
	private Character character;
	private List<Effect> effects;
	
	/**
	 * Manager class that takes cares of effects on characters.
	 * @param character - the character this class will be affecting.
	 */
	public EffectManager(Character character)
	{
		this.character = character;
		effects = new ArrayList<Effect>();
	}
	
	public boolean addEffect(Effect effect)
	{
		if(this.effects.contains(effect))
			return false;
		effect.setManager(this);
		effects.add(effect);
		return true;
	}
	
	public void removeEffect(Effect eff)
	{
		effects.remove(eff);
	}
}
