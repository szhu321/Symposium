package sprite.character.effect;

import sprite.character.Character;
import sprite.character.player.Player;

public class EffectTest
{
	private static Thread thread;
		
	public static void main(String[] args)
	{
		//Character player = new Player(null, 0, 0, 10, 10, null);
		//Effect gainhealth = new GainHealthEffect(10, 10);
		thread = new Thread()
		{
			public void run()
			{
				System.out.println(System.currentTimeMillis());
				try 
				{
					thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		};
	}
}
