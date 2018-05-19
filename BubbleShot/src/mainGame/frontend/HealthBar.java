package mainGame.frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HealthBar 
{
	private Canvas canvas;
	
	private double width;
	private double height;
	private double maxHealth;
	private double currentHealth;
	
	public HealthBar(double width, double height, double maxHealth)
	{
		this.width = width;
		this.height = height;
		this.maxHealth = maxHealth;
		currentHealth = maxHealth;
		buildCanvas();
		updateCanvas(currentHealth, maxHealth);
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
		double healthRatio = (currentHealth / maxHealth);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		if(healthRatio > .5)
			gc.setFill(Color.GREEN);
		else if(healthRatio > .2)
			gc.setFill(Color.YELLOW);
		else if(healthRatio > 0)
			gc.setFill(Color.RED);
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
		gc.setFont(new Font(30));
		gc.setFill(Color.BLACK);
		gc.fillText((int)currentHealth + "/ " +(int)maxHealth, (canvas.getWidth() / 2) - 100, (canvas.getHeight() / 2) + 10);
	}
	
	public static void drawHealthBar(GraphicsContext gc, double x, double y, HealthBar hbar)
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
		this.currentHealth = currentHealth;
		this.maxHealth = maxHealth;
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
		return maxHealth;
	}

	public double getCurrentHealth()
	{
		return currentHealth;
	}
	
}
