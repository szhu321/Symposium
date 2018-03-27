package mainGame;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
import map.obstacle.Obstacle;
import map.obstacle.StoneWall;

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
	private double playerX = 100;
	private double playerY = 100;
	private double playerCenterX = 100;
	private double playerCenterY = 100;
	
	private double mouseX = 0.0;
	private double mouseY = 0.0;
	
	private List<Obstacle> obstacles;
	
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
		
		room.addObstacle(new StoneWall(50, 1000,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0));
		room.addObstacle(new StoneWall(1000, 50,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950));
		
		room.addObstacle(new StoneWall(200,200,200,200));
		room.addObstacle(new StoneWall(200,200,200,600));
		room.addObstacle(new StoneWall(200,200,600,600));
		room.addObstacle(new StoneWall(200,200,600,200));
		room.addObstacle(new StoneWall(70,70,460,460));
		room.addObstacle(new StoneWall(100,50, 450,50));
		
		for(int i = 0; i < roomTiles.length; i++)
			for(int j = 0; j < roomTiles[0].length; j++)
				mapGrid.add(roomTiles[i][j].getImageView(), j, i);
		
		moveArea = new Group();
		Shape rec = new Rectangle(70, 10);
		Shape cir = new Circle(25);
		//player = Shape.union(cir, rec);
		//player = new Rectangle(70, 10);
		player = new Circle(25);
		moveArea.getChildren().add(player);
		
		obstacles = room.getObstacles();
		for(Obstacle obs: obstacles)
		{
			moveArea.getChildren().add(obs.getImgView());
		}
		
		AnimationTimer animation = new AnimationTimer()
		{
			@Override
			public void handle(long systime)
			{
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
		double changeAmount = 1;
		if(shift)
			changeAmount *= 5;
		if(left && canMoveLeft(changeAmount))
			deltaX -= changeAmount;
		if(right && canMoveRight(changeAmount))
			deltaX += changeAmount;
		if(up && canMoveUp(changeAmount))
			deltaY -= changeAmount;
		if(down && canMoveDown(changeAmount))
			deltaY += changeAmount;
		
		playerX += deltaX;
		playerY += deltaY;
	}
	
	private void repositionPlayer()
	{
		player.getTransforms().clear();
		player.getTransforms().add(new Translate(playerX, playerY));
		player.getTransforms().add(new Rotate(mouseAngle));
	}
	
	private void caculateMouseAngleToPlayer()
	{
		double distanceX = mouseX - playerCenterX;
		double distanceY = mouseY - playerCenterY;
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
			KeyCode code = event.getCode();
			if(code == KeyCode.W)
				up = true;
			if(code == KeyCode.A)
				left = true;
			if(code == KeyCode.S)
				down = true;
			if(code == KeyCode.D)
				right = true;
			if(code == KeyCode.SHIFT)
				shift = true;
			//switch(event.getCode())
			//{
			//	case W: up = true; break;
			//	case A: left = true; break;
			//	case S: down = true; break;
			//	case D: right = true; break;
			//	case SHIFT: shift = true; break;
			//}
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
	
	public boolean canMoveRight(double moveAmount)
	{
		player.getTransforms().clear();
		player.getTransforms().add(new Translate(playerX + moveAmount, playerY));
		
		for(int i = 0; i < obstacles.size(); i++)
		{
			if(player.getBoundsInParent().intersects(obstacles.get(i).getImgView().getBoundsInParent()))
			{
				player.getTransforms().clear();
				return false;
			}
				
		}
		player.getTransforms().clear();
		return true;
	}
	
	public boolean canMoveLeft(double moveAmount)
	{
		player.getTransforms().clear();
		player.getTransforms().add(new Translate(playerX - moveAmount, playerY));
		
		for(int i = 0; i < obstacles.size(); i++)
		{
			if(player.getBoundsInParent().intersects(obstacles.get(i).getImgView().getBoundsInParent()))
			{
				player.getTransforms().clear();
				return false;
			}
				
		}
		player.getTransforms().clear();
		return true;
	}
	
	public boolean canMoveUp(double moveAmount)
	{
		player.getTransforms().clear();
		player.getTransforms().add(new Translate(playerX, playerY - moveAmount));
		
		for(int i = 0; i < obstacles.size(); i++)
		{
			if(player.getBoundsInParent().intersects(obstacles.get(i).getImgView().getBoundsInParent()))
			{
				player.getTransforms().clear();
				return false;
			}
				
		}
		player.getTransforms().clear();
		return true;
	}
	
	public boolean canMoveDown(double moveAmount)
	{
		player.getTransforms().clear();
		player.getTransforms().add(new Translate(playerX, playerY + moveAmount));
		
		for(int i = 0; i < obstacles.size(); i++)
		{
			if(player.getBoundsInParent().intersects(obstacles.get(i).getImgView().getBoundsInParent()))
			{
				player.getTransforms().clear();
				return false;
			}
				
		}
		player.getTransforms().clear();
		return true;
	}
}
