package sprite.bounds;

public class BoxCollider
{
	private double x;
	private double y;
	private double width;
	private double height;
	
	public BoxCollider(double xCoords, double yCoords, double width, double height)
	{
		x = xCoords;
		y = yCoords;
		this.width = width;
		this.height = height;
	}
	
	public boolean intersect(BoxCollider other)
	{
		double xMax = x + width;
		double yMax = y + height;
		double otherXMax = other.getX() + other.getWidth();
		double otherYMax = other.getY() + other.getHeight();
		double otherX = other.getX();
		double otherY = other.getY();
		if(checkXBounds(x, xMax, otherX, otherXMax) && checkYBounds(y, yMax, otherY, otherYMax))
			return true;
		return false;
	}
	
	private boolean checkXBounds(double x, double xMax, double otherX, double otherXMax)
	{
		if(otherX >= x && otherX <= xMax)
			return true;
		if(otherXMax >= x && otherXMax <= xMax)
			return true;
		return false;
	}
	
	private boolean checkYBounds(double y, double yMax, double otherY, double otherYMax)
	{
		if(otherY >= y && otherY <= yMax)
			return true;
		if(otherYMax >= y && otherYMax <= yMax)
			return true;
		return false;
	}
	
	public double getHeight() {return height;}
	public double getWidth() {return width;}
	public double getX() {return x;}
	public double getY() {return y;}
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
}
