package sprite.character.effect;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.util.Duration;
import sprite.character.Character;
import myutilities.TimerManager;

public class EffectManager 
{
	public static final double TIMES_RUN_PER_SEC = 30.0;
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
		KeyFrame keyframe = new KeyFrame(Duration.seconds(1.0 / TIMES_RUN_PER_SEC), event -> runAllEffect());
		TimerManager.addKeyFrameToNewTimeline(keyframe);
	}
	
	public boolean addEffect(Effect effect)
	{
		if(effects.contains(effect))
		{
			effect.setEffectTime(effect.getDefaultEffectTime());
			effect.setActive(true);
			//System.out.println(effect);
			return false;
		}		
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
	
	public double getSpeedMultiplier()
	{
		double result = 1;
		for(Effect effect: effects)
		{
			//System.out.println(effect);
			if((effect instanceof SpeedEffect) && effect.isActive())
				result *= effect.getEffectAmount();
		}
		return result;
	}
	
	public double getDamageMultiplier()
	{
		double result = 1;
		for(Effect effect: effects)
		{
			if(effect instanceof DamageEffect && effect.isActive())
				result *= effect.getEffectAmount();
		}
		return result;
	}
	
	public String toString()
	{
		String result = "EffectManager. Character: " + character.toString() + "\n";
		for(Effect effect : effects)
			result += effect.toString() + "\n";
		return result;
	}
}
