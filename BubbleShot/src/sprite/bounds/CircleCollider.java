package sprite.bounds;

public class CircleCollider
{
	private double centerX;
	private double centerY;
	private double raduis;
	
	public CircleCollider(double centerX, double centerY, double radius)
	{
		this.centerX = centerX;
		this.centerY = centerY;
		this.raduis = radius;
	}
	
	public boolean intersect(CircleCollider other)
	{
		double distance = Math.sqrt(Math.pow(this.centerX - other.centerX ,2) + Math.pow(this.centerY - other.centerY, 2));
		if(distance < this.raduis + other.raduis)
			return true;
		return false;
	}
	
	public boolean contains(CircleCollider other)
	{
		double distance = Math.sqrt(Math.pow(this.centerX - other.centerX ,2) + Math.pow(this.centerY - other.centerY, 2));
		if(distance < Math.abs(this.raduis - other.raduis))
			return true;
		return false;
	}
}
