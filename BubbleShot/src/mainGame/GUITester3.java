package mainGame;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import myutilities.Camera;
import sprite.character.player.PlayerDesign;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import mainGame.frontend.AmmoBar;
import mainGame.frontend.HealthBar;
import map.LevelDesign;
import map.Room;
import map.RoomDesign;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import map.obstacle.StoneWall;

/**
 * Class for Testing
 * 
 */
public class GUITester3 extends Application
{
	
	public Stage window;
	private Scene scene;
	
	private Group root;
	private Canvas mapDis = new Canvas(200,200);

	private long time;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("canvas");
		
//		HealthBar hbar = new HealthBar(100,20,10);
//		AmmoBar abar = new AmmoBar(100,20,10);
//		
//		root = new Group();
//		root.getChildren().addAll(abar.getCanvas(), hbar.getCanvas());
//		hbar.updateCanvas(5);
//		
//		hbar.getCanvas().setLayoutY(30);
//		GraphicsContext gc = hbar.getCanvas().getGraphicsContext2D();
//		
		root = new Group();
		root.getChildren().add(mapDis);
		scene = new Scene(root);
		window.setScene(scene);
		GraphicsContext gc = mapDis.getGraphicsContext2D();
		Tile[][] tiles = LevelDesign.getLevelDesignOne(PlayerDesign.getSimpleStarterPlayer("BoR")).getCurrentRoom().getTiles();
		
		time = System.nanoTime();
		for(int row = 0; row < tiles.length; row++)
		{
			for(int col = 0; col < tiles[0].length; col++)
			{
				Tile tile = tiles[row][col];
				gc.drawImage(tile.getSpriteImage(), tile.getXLocation(), tile.getYLocation());
			}
		}
		System.out.println(System.nanoTime() - time);
		
		
		
		window.show();
		
	}
	
	
	
}
