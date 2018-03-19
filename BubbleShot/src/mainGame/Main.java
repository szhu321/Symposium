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

public class Main extends Application
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
		
		moveArea.getChildren().add(player);
		
		AnimationTimer animation = new AnimationTimer()
		{
			@Override
			public void handle(long systime)
			{
				Shape playerSprite = player;
				double deltaX = 0;
				double deltaY = 0;
				if(left)
					deltaX -= 1;
				if(right)
					deltaX += 1;
				if(up)
					deltaY -= 1;
				if(down)
					deltaY += 1;
				if(shift)
				{
					deltaX *= 5;
					deltaY *= 5;
				}
				playerX += deltaX;
				playerY += deltaY;
				player.getTransforms().clear();
				player.getTransforms().add(new Translate(playerX, playerY));
				playerRotate = new Rotate(mouseAngle);
				player.getTransforms().add(playerRotate);
				//System.out.println(playerCenterX);
				//moveNode(playerSprite, deltaX, deltaY);
				//rotateNode(playerSprite, mousemouseAngle, playerSprite.getBoundsInLocal().getWidth() / 2,playerSprite.getBoundsInLocal().getHeight() / 2);
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
	
	
	
	public void moveNode(Node node, double deltaX, double deltaY)
	{
		node.setLayoutX(node.getLayoutX() + deltaX);
		node.setLayoutY(node.getLayoutY() + deltaY);
	}
	
	public void rotateNode(Node node, double mouseAngle, double axisX, double axisY)
	{
		node.getTransforms().clear();
		node.getTransforms().add(new Rotate(mouseAngle, axisX, axisY));
	}
	
	public void applyKeyEvents(Scene scene)
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
			player.getTransforms().clear();
			double mouseX = event.getSceneX();
			double mouseY = event.getSceneY();
			
			double recBPX = player.getBoundsInParent().getMinX();
			double recBPY = player.getBoundsInParent().getMinY();
			
			//System.out.println("MinX: " + recBPX);
			//System.out.println("MinY: " + recBPY);
			
			double recCenterX = playerX/*recBPX*/ + (player.getBoundsInParent().getWidth() / 2);
			double recCenterY = playerY/*recBPY*/ + (player.getBoundsInParent().getHeight() / 2);
			
			playerCenterX = recCenterX;
			playerCenterY = recCenterY;
			
			//System.out.println("Width: " + player.getBoundsInLocal().getWidth());
			//System.out.println("Width: " + player.getBoundsInParent().getWidth());
			
			double distanceX = mouseX - recCenterX;
			double distanceY = mouseY - recCenterY;
			
			//System.out.println("PivotX : " + recCenterX);
			//System.out.println("PivotY : " + recCenterY);
			
			mouseAngle = Math.toDegrees(Math.atan(distanceY / distanceX));
			if(distanceY <= 0 && distanceX < 0)
				mouseAngle += 180;
			if(distanceY > 0 && distanceX < 0)
				mouseAngle = 90 + (90 - Math.abs(mouseAngle));
			//System.out.println(mouseAngle);
			//player.getTransforms().add(new Rotate(mouseAngle, recCenterX, recCenterY));
		});
		
		
	}
}
