package sprite.character.effect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.util.Duration;
import sprite.character.Character;
import myutilities.TimerManager;

public class EffectManager implements Serializable
{
	private static final long serialVersionUID = -1622860748433164140L;
	
	public static final double TIMES_RUN_PER_SEC = 60.0;
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
		//setUpTimer();
	}
	
//	public void setUpTimer()
//	{
//		KeyFrame keyframe = new KeyFrame(Duration.seconds(1.0 / TIMES_RUN_PER_SEC), event -> runAllEffect());
//		TimerManager.addKeyFrameToNewTimeline(keyframe);
//	}
	
	public boolean addEffect(Effect effect)
	{
		if(effects.contains(effect))
		{
			effect.setEffectTime(effect.getDefaultEffectTime());
			effect.setActive(true);
			//System.out.println(effect);
			return false;
		}	
		//System.out.println(effect);	
		effect.setManager(this);
		effect.setActive(true);
		effects.add(effect);
		return true;
	}
	
	public void runAllEffect(double sec)
	{
		for(Effect effect : effects)
		{
			effect.applyEffect(character, sec);
			//System.out.println(effect);
		}
			
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
	
	public boolean isTakingDamage()
	{
		for(Effect effect: effects)
		{
			//System.out.println(effect);
			if(effect instanceof HealthEffect && effect.isActive() && effect.getEffectAmount() < 0)
				return true;
		}
		return false;
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
	
	public boolean isBlindActive()
	{
		for(Effect effect: effects)
		{
			if(effect instanceof BlindEffect && effect.isActive())
				return true;
		}
		return false;
	}
	
	public String toString()
	{
		String result = "EffectManager. Character: " + character.toString() + "\n";
		for(Effect effect : effects)
			result += effect.toString() + "\n";
		return result;
	}
}
