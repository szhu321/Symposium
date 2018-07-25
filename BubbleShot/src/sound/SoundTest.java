package sound;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class SoundTest extends Application
{
	private Stage window;
	private Scene scene;
	private MediaView mediaView;
	private Group root;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("music");
		
		//BackgroundSound bs = new BackgroundSound("resources/music/AlanWForce.mp3", 232);
		//bs.playSound();
		
		SoundEffects.GUN_SHOT_SOUND.playSound();
		
		//mediaView = new MediaView(bs.getMediaPlayer());
		
		root = new Group();
		//root.getChildren().add(mediaView);
		
		scene = new Scene(root);
		window.setScene(scene);
		window.show();
	}
}
