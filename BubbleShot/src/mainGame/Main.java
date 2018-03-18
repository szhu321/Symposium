package mainGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import map.Room;
import map.Tile.Tile;

public class Main extends Application
{
	private Stage window;
	private Scene scene;
	private Group moveArea;
	private GridPane mapGrid;
	private Group root;
	
	private Boolean up = false;
	private Boolean down = false;
	private Boolean left = false;
	private Boolean right = false;
	private Boolean shift = false;
	private double mouseAngle = 0.0;
	
	private Circle player;
	
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
		player = new Circle(25);
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
				moveNode(playerSprite, deltaX, deltaY);
				rotateNode(playerSprite, mouseAngle, playerSprite.getBoundsInLocal().getWidth() / 2,playerSprite.getBoundsInLocal().getHeight() / 2);
			}
		};
		animation.start();
		
		
		
		root.getChildren().add(mapGrid);
		root.getChildren().add(moveArea);
		
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
	
	public void rotateNode(Node node, double angle, double axisX, double axisY)
	{
		node.getTransforms().clear();
		node.getTransforms().add(new Rotate(angle, axisX, axisY));
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
		scene.setOnMouseMoved(event -> 
		{
			event.getX();
			event.getY();
		});
	}
}
