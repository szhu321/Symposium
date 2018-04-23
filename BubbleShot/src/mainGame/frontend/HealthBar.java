package mainGame.frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
		updateCanvas(currentHealth);
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
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public void updateCanvas(double currentHealth)
	{
		this.currentHealth = currentHealth;
		clearCanvas();
		paintMiddle();
		paintBorder();
	}
}
