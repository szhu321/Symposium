package sprite.bounds;

import sprite.projectile.CollisionDetection;

public class BoxCollider
{
	private int x;
	private int y;
	private int width;
	private int height;
	
	public BoxCollider(double xCoords, double yCoords, double width, double height, double faceAngle)
	{
		x = (int)xCoords;
		y = (int)yCoords;
		this.width = (int)width;
		this.height = (int)height;
	}
	
	public boolean intersect(BoxCollider other)
	{
//		double xMax = x + width;
//		double yMax = y + height;
//		double otherXMax = other.getX() + other.getWidth();
//		double otherYMax = other.getY() + other.getHeight();
//		double otherX = other.getX();
//		double otherY = other.getY();
//		if((checkXBounds(x, xMax, otherX, otherXMax) && checkYBounds(y, yMax, otherY, otherYMax)) /*|| contains(other)*/)
//			return true;
//		return false;
		if(x < other.getX() + other.getWidth() &&
		   x + width > other.getX() &&
		   y < other.getY() + other.getHeight() &&
		   y + height > other.getY())
			return true;
		return false;
	}
	
//	private boolean checkXBounds(double x, double xMax, double otherX, double otherXMax)
//	{
//		if(otherX >= x && otherX <= xMax || x <= otherX && xMax >= otherXMax)
//			return true;
//		if(otherXMax >= x && otherXMax <= xMax || otherX <= x && otherXMax >= xMax)
//			return true;
//		return false;
//	}
//	
//	private boolean checkYBounds(double y, double yMax, double otherY, double otherYMax)
//	{
//		if(otherY >= y && otherY <= yMax || y <= otherY && yMax >= otherYMax)
//			return true;
//		if(otherYMax >= y && otherYMax <= yMax || otherY <= y && otherYMax >= yMax)
//			return true;
//		return false;
//	}
	
	public boolean contains(BoxCollider other)
	{
		double xMax = x + width;
		double yMax = y + height;
		double otherXMax = other.getX() + other.getWidth();
		double otherYMax = other.getY() + other.getHeight();
		double otherX = other.getX();
		double otherY = other.getY();
		if(x < otherX && xMax > otherXMax && y < otherY && yMax > otherYMax)
			return true;
		if(otherX < x && otherXMax > xMax && otherY < y && otherYMax > yMax)
			return true;
		return false;
	}

	
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public int getX() {return x;}
	public int getY() {return y;}
	public void setX(double x) {this.x = (int)x;}
	public void setY(double y) {this.y = (int)y;}
	
	public String toString()
	{
		return "X: " + x + " Y: " + y + " Width: " + width + " Height: " + height;
	}
}
