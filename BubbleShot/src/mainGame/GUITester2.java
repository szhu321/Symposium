package mainGame;

import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import map.Room;
import map.Tile.Tile;
import map.obstacle.Obstacle;
import map.obstacle.StoneWall;

public class GUITester2 extends Application
{
	
	private Stage window;
	private Scene scene;
	private ImageView player;
	private Group root;
	private Group movingArea;
	private GridPane mapGrid;

	
	private Boolean up = false;
	private Boolean down = false;
	private Boolean left = false;
	private Boolean right = false;
	private Boolean shift = false;
	private double mouseAngle = 0.0;
	private double mouseX = 0.0;
	private double mouseY = 0.0;
	
	private double playerX = 110;
	private double playerY = 110;
	
	private List<Obstacle> obstacles;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("Test GUI without Transforms()");
		
		player = new ImageView(new Image("file:resources/player/player1.png", 70,70, false,false));
		movingArea = new Group();
		movingArea.getChildren().add(player);
		
		root = new Group();
		mapGrid = new GridPane();
		Room room = new Room();
		Tile[][] roomTiles = room.getTiles();
		
		room.addObstacle(new StoneWall(50, 1000,0,0,0));
		room.addObstacle(new StoneWall(50, 1000,950,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,0,0));
		room.addObstacle(new StoneWall(1000, 50,0,950,0));
		
		room.addObstacle(new StoneWall(200,200,200,200,0));
		room.addObstacle(new StoneWall(200,200,200,600,0));
		room.addObstacle(new StoneWall(200,200,600,600,0));
		room.addObstacle(new StoneWall(200,200,600,200,0));
		
		
		for(int i = 0; i < roomTiles.length; i++)
			for(int j = 0; j < roomTiles[0].length; j++)
				mapGrid.add(roomTiles[i][j].getImageView(), j, i);
		
		obstacles = room.getObstacles();
		for(Obstacle obs: obstacles)
		{
			movingArea.getChildren().add(obs.getSpriteImageView());
		}
		
		root = new Group();
		root.getChildren().addAll(mapGrid ,movingArea);
		
		
		
		scene = new Scene(root);
		applyKeyEvents(scene);
		window.setScene(scene);
		window.show();
		
		AnimationTimer animation = new AnimationTimer()
		{
			@Override
			public void handle(long systime)
			{
				caculateMovement();
				caculateMouseAngleToPlayer();
				repositionPlayer();
				//repositionCamera();
			}
		};
		animation.start();
		//repositionPlayer();
		//player.setRotate(180);
		//player.setRotate(240);
		//player.setRotate(-90);
		//player.setRotate(-90);
		//player.setRotate(.1);
	}
	
	private void repositionPlayer()
	{
		player.setTranslateX(playerX);
		player.setTranslateY(playerY);
		player.setRotate(mouseAngle);
	}
	
	/*private void repositionCamera()
	{
		camera.shiftCamera(playerX, playerY,window.getWidth(),window.getHeight());
		
		moveArea.getTransforms().clear();
		mapGrid.getTransforms().clear();
		
		
		moveArea.getTransforms().add(new Translate(camera.getxCoord(),camera.getyCoord()));
		mapGrid.getTransforms().add(new Translate(camera.getxCoord(),camera.getyCoord()));
	}*/
	
	private void caculateMovement() 
	{
		double deltaX = 0;
		double deltaY = 0;
		double changeAmount = 1;
		if(shift)
			changeAmount *= 5;
		if(left)
			deltaX -= changeAmount;
		if(right)
			deltaX += changeAmount;
		if(up)
			deltaY -= changeAmount;
		if(down)
			deltaY += changeAmount;
		
		playerX += deltaX;
		playerY += deltaY;
	}
	
	private void caculateMouseAngleToPlayer()
	{
		double distanceX = mouseX - playerX - player.getBoundsInLocal().getWidth()/2;
		double distanceY = mouseY - playerY - player.getBoundsInLocal().getHeight()/2;
		
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
