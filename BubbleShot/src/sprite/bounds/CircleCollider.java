package sprite.bounds;

public class CircleCollider
{
	private double centerX;
	private double centerY;
	private double radius;
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public CircleCollider(double centerX, double centerY, double radius)
	{
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	public boolean intersect(CircleCollider other)
	{
		double distance = Math.sqrt(Math.pow(this.centerX - other.centerX ,2) + Math.pow(this.centerY - other.centerY, 2));
		if(distance < this.radius + other.radius)
			return true;
		return false;
	}
	
	public boolean contains(CircleCollider other)
	{
		double distance = Math.sqrt(Math.pow(this.centerX - other.centerX ,2) + Math.pow(this.centerY - other.centerY, 2));
		if(distance < Math.abs(this.radius - other.radius))
			return true;
		return false;
	}	
}
