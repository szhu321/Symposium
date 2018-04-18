package sprite.character.enemy;

public class EnemyDesign
{
	public static Enemy getRegularDesignOne(double x, double y)
	{
		String fileName = "file:resources/enemy/enemy.png";
		Enemy enemy=new Regular("Brian",fileName, x, y,100,  50, 60, 60, null,null);
		return enemy;
	}
	
	public static Boss getBossDesignOne()
	{
		return null;
	}
}
