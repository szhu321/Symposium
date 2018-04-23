package mainGame.frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AmmoBar 
{
	private Canvas canvas;
	
	private double width;
	private double height;
	private double maxAmmo;
	private double currentAmmo;
	
	public AmmoBar(double width, double height, double maxAmmo)
	{
		this.width = width;
		this.height = height;
		this.maxAmmo = maxAmmo;
		currentAmmo = maxAmmo;
		buildCanvas();
		updateCanvas(currentAmmo);
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
		double AmmoRatio = (currentAmmo / maxAmmo);
		GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, width * AmmoRatio, height);
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
	
	public void updateCanvas(double currentAmmo)
	{
		this.currentAmmo = currentAmmo;
		clearCanvas();
		paintMiddle();
		paintBorder();
	}
}
