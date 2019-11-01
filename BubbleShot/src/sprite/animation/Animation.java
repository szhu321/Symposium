package sprite.animation;

import java.util.HashMap;
import java.util.Map;

public class Animation
{
	//array of animations.
	private Map<String, AniState> animations;
	
	public Animation()
	{
		animations = new HashMap<String, AniState>();
	}
	
	/**
	 * File naming scheme: CharacterName_Idle/Walk_Number
	 */
	public void loadCharacters()
	{
		
	}
}
