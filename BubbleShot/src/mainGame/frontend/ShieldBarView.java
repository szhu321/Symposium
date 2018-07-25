package mainGame.frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ShieldBarView 
{
	private Canvas canvas;
	private double width;
	private double height;
	private double maxShield;
	private double currentShield;
	
	public ShieldBarView(double width, double height, double maxShield)
	{
		this.width = width;
		this.height = height;
		this.maxShield = maxShield;
		currentShield = maxShield;
		buildCanvas();
		updateCanvas(currentShield, maxShield);
	}
	
	private void buildCanvas()
	{
		canvas = new Canvas();
		canvas.setHeight(height);
		canvas.setWidth(width);
		canvas.setStyle("-fx-border-radius:10px");
	}
	
	private void paintBorder()
	{
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.strokeRect(0, 0, width, height);
	}
	
	private void paintMiddle()
	{
		double healthRatio = (currentShield / maxShield);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.PURPLE);
		gc.fillRect(0, 0, width * healthRatio, height);
	}
	
	private void clearCanvas()
	{
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, width, height);
	}
	
	private void paintText()
	{
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFont(new Font(20));
		gc.setFill(Color.BLACK);
		gc.fillText((int)currentShield + "/ " +(int)maxShield, (canvas.getWidth() / 2) - 100, (canvas.getHeight() / 2) + 10);
	}
	
	public static void drawHealthBar(GraphicsContext gc, double x, double y, ShieldBarView hbar)
	{
		double width = hbar.getWidth();
		double height = hbar.getHeight();
		double currentHealth = hbar.getCurrentHealth();
		double maxHealth = hbar.getMaxHealth();
		//Clear Canvas
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, width, height);
		
		//Paint Middle
		double healthRatio = (currentHealth / maxHealth);
		if(healthRatio > .5)
			gc.setFill(Color.GREEN);
		else if(healthRatio > .2)
			gc.setFill(Color.YELLOW);
		else if(healthRatio > 0)
			gc.setFill(Color.RED);
		gc.fillRect(x, y, width * healthRatio, height);
		
		//Paint Border
		gc.setStroke(Color.BLACK);
		gc.strokeRect(x, y, width, height);
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public void updateCanvas(double currentHealth, double maxHealth)
	{
		this.currentShield = currentHealth;
		this.maxShield = maxHealth;
		clearCanvas();
		paintMiddle();
		paintBorder();
		paintText();
	}

	public double getWidth() 
	{
		return width;
	}

	public double getHeight() 
	{
		return height;
	}

	public double getMaxHealth()
	{
		return maxShield;
	}

	public double getCurrentHealth()
	{
		return currentShield;
	}
	
}
