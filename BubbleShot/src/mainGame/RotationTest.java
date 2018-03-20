package mainGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
import map.Room;
import map.Tile.Tile;

public class RotationTest extends Application
{
	private Stage window;
	private Scene scene;
	private Group moveArea;
	private GridPane mapGrid;
	private BorderPane headsUpDis;
	private Group root;
	
	private Boolean up = false;
	private Boolean down = false;
	private Boolean left = false;
	private Boolean right = false;
	private Boolean shift = false;
	private double mouseAngle = 0.0;
	
	private Shape player;
	private double playerX = 0.0;
	private double playerY = 0.0;
	private double playerCenterX = 0.0;
	private double playerCenterY = 0.0;
	private Rotate playerRotate;
	
	private double mouseX = 0.0;
	private double mouseY = 0.0;
	
	private long currentTime = 0;
	
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
		mapGrid = new GridPane();
		Room room = new Room();
		Tile[][] roomTiles = room.getTiles();
		
		for(int i = 0; i < roomTiles.length; i++)
			for(int j = 0; j < roomTiles[0].length; j++)
				mapGrid.add(roomTiles[i][j].getImageView(), j, i);
		
		moveArea = new Group();
		Shape rec = new Rectangle(70, 10);
		Shape cir = new Circle(25);
		player = Shape.union(cir, rec);
		//player = new Rectangle(70, 10);
		//player = new Circle(25);
		
		playerCenterX = player.getBoundsInParent().getWidth() / 2;
		playerCenterY = player.getBoundsInParent().getHeight() / 2;
		
		//System.out.println(playerCenterX);
		//System.out.println(playerCenterY);
		
		moveArea.getChildren().add(player);
		
		AnimationTimer animation = new AnimationTimer()
		{
			@Override
			public void handle(long systime)
			{
				//System.out.println("FPS: " + (systime - currentTime)/1000000);
				//currentTime = systime;
				caculateMovement();
				caculateMouseAngleToPlayer();
				repositionPlayer();
			}
		};
		animation.start();
		
		
		headsUpDis = new BorderPane();
		Text health = new Text("Health: 10");
		health.setFont(new Font(30));
		health.setStyle("fx-background-color : #FFFFFF");
		headsUpDis.setTop(health);
		
		root.getChildren().add(mapGrid);
		root.getChildren().add(moveArea);
		root.getChildren().add(headsUpDis);
		
		
		
		scene = new Scene(root);
		applyKeyEvents(scene);
		window.setScene(scene);
		window.show();
	}
	
	private void caculateMovement() 
	{
		double deltaX = 0;
		double deltaY = 0;
		if(left)
			deltaX -= 2;
		if(right)
			deltaX += 2;
		if(up)
			deltaY -= 2;
		if(down)
			deltaY += 2;
		if(shift)
		{
			deltaX *= 5;
			deltaY *= 5;
		}
		playerX += deltaX;
		playerY += deltaY;
		playerCenterX += deltaX;
		playerCenterY += deltaY;
	}
	
	private void repositionPlayer()
	{
		player.getTransforms().clear();
		player.getTransforms().add(new Translate(playerX, playerY));
		//playerRotate = new Rotate(mouseAngle);//player.getBoundsInLocal().getWidth()/2, player.getBoundsInLocal().getHeight()/2);
		player.getTransforms().add(new Rotate(mouseAngle));
		
		//System.out.println("playerCenterX: " + playerCenterX);
		//System.out.println("playerCenterY: " + playerCenterY);
		//System.out.println("mosueX: " + mouseX);
		//System.out.println("mouseY: " + mouseY);
	}
	
	private void caculateMouseAngleToPlayer()
	{
		
		//System.out.println("playerX: " + playerX);
		//System.out.println("playerY: " + playerY);
		
		//System.out.println("playerCenterX: " + playerCenterX);
		//System.out.println("playerCenterY: " + playerCenterY);
		
		//System.out.println("mouseAngle: " + mouseAngle);
		
		double distanceX = mouseX - playerCenterX;
		double distanceY = mouseY - playerCenterY;
		//System.out.println(distanceX);
		//System.out.println(distanceY);
		
		mouseAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
		if(distanceY <= 0 && distanceX < 0)
			mouseAngle += 180;
		if(distanceY > 0 && distanceX < 0)
			mouseAngle = 90 + (90 - Math.abs(mouseAngle));
	}
	
	private void applyKeyEvents(Scene scene)
	{
		scene.setOnKeyPressed(event -> 
		{
			switch(event.getCode())
			{
				case W: up = true; break;
				case A: left = true; break;
				case S: down = true; break;
				case D: right = true; break;
				case SHIFT: shift = true; break;
			}
		});
		scene.setOnKeyReleased(event -> 
		{
			switch(event.getCode())
			{
				case W: up = false; break;
				case A: left = false; break;
				case S: down = false; break;
				case D: right = false; break;
				case SHIFT: shift = false; break;
			}
		});
		scene.addEventHandler(MouseEvent.ANY, event -> 
		{
			mouseX = event.getX();
			mouseY = event.getY();
		});
	}
}
