package sprite.character.effect;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.util.Duration;
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
		setUpTimer();
	}
	
	public void setUpTimer()
	{
		KeyFrame keyframe = new KeyFrame(Duration.seconds(1), event -> runAllEffect());
	}
	
	public boolean addEffect(Effect effect)
	{
		if(effects.contains(effect))
			return false;
		effect.setManager(this);
		effects.add(effect);
		return true;
	}
	
	public void runAllEffect()
	{
		for(Effect effect : effects)
			effect.applyEffect(character);
	}
	
	public Character getCharacter() {return character;}
	
	public void removeEffect(Effect eff)
	{
		effects.remove(eff);
	}
	
	public String toString()
	{
		String result = "EffectManager. Character: " + character.toString() + "\n";
		for(Effect effect : effects)
			result += effect.toString() + "\n";
		return result;
	}
}
