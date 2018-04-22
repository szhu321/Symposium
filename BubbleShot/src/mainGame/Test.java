package mainGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Class for Testing
 * 
 */
public class Test extends Application
{
	private Stage window;
	private Scene scene;
	private Group root;
	private Rectangle rec;
	private double angle;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("BubbleShot");
		
		rec = new Rectangle(200,200,100,50);
		angle = 0.0;
		root = new Group();
		root.getChildren().add(rec);
		root.getChildren().add(new ImageView(new Image("file:resources/projectilePictures/bullet.png")));
		
		AnimationTimer animate = new AnimationTimer() 
		{
			@Override
			public void handle(long now)
			{
				//System.out.println(now);
			}
		};
		animate.start();
		
		
		
		scene = new Scene(root, 500, 500);
		new EventHandler<Event>()
		{
			public void handle(Event event)
			{
				
			}
		};
		scene.setOnMouseMoved(event -> 
		{
			rec.getTransforms().clear();
			double mouseX = event.getX();
			double mouseY = event.getY();
			//double mouseSX = event.getSceneX();
			//double mouseSY = event.getSceneY();
			
			//System.out.println("mouseX: " + mouseX + " mouseY: " + mouseY);
			//System.out.println("mouseSX: " + mouseSX + " mouseSY: " + mouseSY);
			
			//double recBLX = rec.getBoundsInLocal().getMinX();
			//double recBLY = rec.getBoundsInLocal().getMinY();
			
			double recBPX = rec.getBoundsInParent().getMinX();
			double recBPY = rec.getBoundsInParent().getMinY();
			
			System.out.println("MinX: " + recBPX);
			System.out.println("MinY: " + recBPY);
			//double recCenterX = recBPX + (rec.getBoundsInParent().getWidth() / 2);
			//double recCenterY = recBPY + (rec.getBoundsInParent().getHeight() / 2);
			
			
			
			double recCenterX = recBPX + (rec.getBoundsInParent().getWidth() / 2);
			double recCenterY = recBPY + (rec.getBoundsInParent().getHeight() / 2);
			//System.out.println("Bounds in local X: " + recBLX + " Bounds in local Y: " + recBLY);
			//System.out.println("Bounds in parent X: " + recBPX + " Bounds in parent Y: " + recBPY);
			
			double distanceX = mouseX - recCenterX;
			double distanceY = mouseY - recCenterY;
	
			System.out.println("X distance: " + distanceX + " Y distance: " + distanceY);
			System.out.println("PivotX : " + recCenterX);
			System.out.println("PivotY : " + recCenterY);
			System.out.println("Width: " + rec.getBoundsInLocal().getWidth());
			System.out.println("Width: " + rec.getBoundsInParent().getWidth());
			angle = Math.toDegrees(Math.atan(distanceY / distanceX));
			double angle2 = Math.toDegrees(Math.atan2(recCenterX - mouseX, recCenterY - mouseY) - Math.PI/2);
			System.out.println("angle2: " + angle2);
			if(distanceY <= 0 && distanceX < 0)
			{
				angle += 180;
			}
			if(distanceY > 0 && distanceX < 0)
			{
				angle = 90 + (90 - Math.abs(angle));
			}
			
			System.out.println("Angle: " + angle);
			
			rec.getTransforms().add(new Rotate(angle, recCenterX, recCenterY));
		});
		
		window.setScene(scene);
		window.show();
	}
}