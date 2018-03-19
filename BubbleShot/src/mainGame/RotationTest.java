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

public class RotationTest extends Application
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
		
		root = new Group();
		rec = new Rectangle(50, 100);
		root.getChildren().add(rec);
		
		rec.getTransforms().add(new Translate(100,100));
		rec.getTransforms().add(new Rotate(90));
		
		scene = new Scene(root, 500,500);
		window.setScene(scene);
		window.show();
	}
}