package mainGame.frontend;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mainGame.backend.GameManager;
import map.Level;
import map.LevelDesign;
import map.Room;
import map.RoomDesign;
import sprite.character.player.Player;
import sprite.character.player.PlayerDesign;

public class FontendTest extends Application
{
	private Stage window;
	private Scene scene;
	private Group root;
	
	private double health;
	private double ammo;
	
	public static void main(String[] args)
	{
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("TEST HEALTHBAR");
		
		root = new Group();
//		health = 1000;
//		ammo = 100;
//		HealthBar healthbar = new HealthBar(300, 20, health);
//		AmmoBar ammobar = new AmmoBar(300, 20, ammo);
//		ammobar.getCanvas().setTranslateY(30);
//		
//		
//		Button btn = new Button("ATTACK");
//		btn.setOnAction(event -> 
//		{
//			health -= 100;
//			healthbar.updateCanvas(health);
//		});
//		btn.setTranslateY(100);
//		Button btn2 = new Button("SHOOT");
//		btn2.setOnAction(event -> 
//		{
//			ammo -= 1;
//			ammobar.updateCanvas(ammo);
//		});
//		btn2.setTranslateY(130);
//		
//		root.getChildren().addAll(healthbar.getCanvas(), btn, ammobar.getCanvas(), btn2);
		
		Player player = PlayerDesign.getSimpleStarterPlayer("Joy");
		Level level = LevelDesign.getLevelDesignOne(player);
		
		Room room = level.getCurrentRoom();
		
		RoomView roomDis = new RoomView(room);
		
		root.getChildren().add(roomDis.getCanvas());
		
		scene = new Scene(root, 500 ,500);
		window.setScene(scene);
		window.show();
	}

}
