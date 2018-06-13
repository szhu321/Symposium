package mainGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import mainGame.backend.GameManager;
import mainGame.saving.FileReader;
import map.Level;
import map.LevelDesign;
import sound.BackgroundSound;
import sprite.character.player.Player;
import sprite.character.player.PlayerDesign;

/**
 * Run this class to start the Program.
 * @author Sheng 	
 *
 */
public class GameRunner extends Application
{	
	private static Stage window;
	private static GameManager gameManager;
	private static SceneTracker sceneTracker;
	
	private static double resolutionHeight;
	private static double resolutionWidth;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("Lost Cause");
		resolutionHeight = Screen.getPrimary().getVisualBounds().getHeight();
		resolutionWidth = Screen.getPrimary().getVisualBounds().getWidth();
		window.setHeight(resolutionHeight);
		window.setWidth(resolutionWidth);
		window.setResizable(false);
		Player player = PlayerDesign.getSimpleStarterPlayer("Joy");
////		//Enemy[] enemyList= {EnesmyDesign.getRegularDesignOne(500, 500,player),EnemyDesign.getRegularDesignOne(500, 600,player)};
		gameManager = new GameManager(LevelDesign.getRandomLevelDesign(5, 5), player, window);
		gameManager.startGame();
		
//		BackgroundSound bs = new BackgroundSound("resources/music/AlanWForce.mp3", 232);
//		bs.playSound(.05);
//		
//		loadFXMLs();
		
		
		window.show();
	}
	
	private void loadFXMLs() throws Exception
	{
		//Loads the scene Tracker then sets the scene to the MainMenuView();
		sceneTracker = new SceneTracker(window);
		sceneTracker.switchToMainMenuView();
	}
	
	/**
	 * Sets the scene of the game window.
	 * This method is static since there will onlySS be 
	 * one game window. Everything should be displayed in this window.
	 * 
	 * @param scene The scene the window will show.
	 */
	public static void setScene(Scene scene)
	{
		window.setScene(scene);
	}
	
	public static double getWindowHeight()
	{
		return window.getHeight();
	}
	
	public static double getWindowWidth()
	{
		return window.getWidth();
	}
	
	public static double getResolutionHeight()
	{
		return resolutionHeight;
	}

	public static double getResolutionWidth() 
	{
		return resolutionWidth;
	}

	public static Stage getWindow()
	{
		return window;
	}
	
	public static SceneTracker getSceneTracker() 
	{
		return sceneTracker;
	}

	public static GameManager getGameManager()
	{
		return gameManager;
	}
	
	public static void createGameManager(Level level, Player player)
	{
		gameManager = new GameManager(level, player, window);
	}
	
	public static void startGameManager()
	{
		if(gameManager != null)
			gameManager.startGame();
		else
			System.out.println("Null Gamemanager");
	}
}
