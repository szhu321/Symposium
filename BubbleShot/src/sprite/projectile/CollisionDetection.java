package sprite.projectile;


import sprite.Sprite;
import sprite.character.Character;
import java.awt.Point;
import sprite.projectile.Vector2D;

public interface CollisionDetection
{
	//dot product
	//char is a circle, proj is a square
	//
	public static boolean collides(Sprite proj, Sprite charSprite)
	{
		//further point minus the closer point to make vector
		//normalize
		//looping through the corner points, make a vector from the center to the corner point
		//and find the dot product of that with the normalized vector
		//find the max of all four points
		//if the magnitude of the normalized vector minus the max minus the radius of the 
		//circle is greater than 0 and the magnitude of the normalized vector is greater than 0
		//there is no collision, otherwise there is
		double max = Integer.MIN_VALUE;
		Vector2D projectionVector = new Vector2D(Math.abs(proj.getXCenter() - charSprite.getXCenter()), Math.abs(proj.getYCenter() - charSprite.getYCenter()));
		Vector2D proVectorNormed = projectionVector.normalize();
		Point[] charSpritePts = new Point[4];
		charSpritePts[0] = new Point((int)(charSprite.getXCenter() - (charSprite.getWidth()/2)), 
				(int)(charSprite.getYCenter() - (charSprite.getHeight()/2)));
		charSpritePts[1] = new Point((int)(charSprite.getXCenter() - (charSprite.getWidth()/2)), 
				(int)(charSprite.getYCenter() + (charSprite.getHeight()/2)));
		charSpritePts[2] = new Point((int)(charSprite.getXCenter() + (charSprite.getWidth()/2)), 
				(int)(charSprite.getYCenter() - (charSprite.getHeight()/2)));
		charSpritePts[3] = new Point((int)(charSprite.getXCenter() + (charSprite.getWidth()/2)), 
				(int)(charSprite.getYCenter() + (charSprite.getHeight()/2)));
		for(int i = 0; i < 4; i++)
		{
			Point currentCorner = charSpritePts[i];
			Vector2D vMaxTest = new Vector2D((int)(currentCorner.getX()), (int)(currentCorner.getY()));
			double currentProjection = vMaxTest.dotProduct(proVectorNormed);
			if(currentProjection > max)
				max = currentProjection;
		}
		if(projectionVector.length() - max - (proj.getHeight()/2) > 0 && projectionVector.length() 
				> 0)
			return false;
		return true;
	}
}
