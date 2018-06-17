package mainGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Screen;
import mainGame.backend.Controls;
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
	
	private static Controls controls;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		/*
		 * - Start method sets up the window by first setting the title and then adjusting 
		 * the size of the window based on user screen.
		 * - Next it loads up the controls from a save file. If there is no save file 
		 * create a new one and apply default controls.
		 * - Then it loads up the FXML files for the main menu.
		 * - Finally the window starts displaying the first scene, which is the main menu.
		 */
		window = primaryStage;
		window.setTitle("Lost Cause");
		resolutionHeight = Screen.getPrimary().getVisualBounds().getHeight();
		resolutionWidth = Screen.getPrimary().getVisualBounds().getWidth();
		window.setHeight(resolutionHeight);
		window.setWidth(resolutionWidth);
		window.setResizable(false);
		loadControls();
		loadFXMLs();
		
		
//		Player player = PlayerDesign.getSimpleStarterPlayer("Joy");
////////	//Enemy[] enemyList= {EnesmyDesign.getRegularDesignOne(500, 500,player),EnemyDesign.getRegularDesignOne(500, 600,player)};
//		gameManager = new GameManager(LevelDesign.getLevelTestBoss(), player, window, controls);
//		gameManager.startGame();
//		
//		BackgroundSound bs = new BackgroundSound("resources/music/AlanWForce.mp3", 232);
//		bs.playSound(.05);
//		
		
		window.show();
	}
	
	/**
	 * Loads the main menu.
	 * @throws Exception 
	 */
	private void loadFXMLs() throws Exception
	{
		//Loads the scene Tracker then sets the scene to the MainMenuView();
		sceneTracker = new SceneTracker(window);
		sceneTracker.switchToMainMenuView();
	}
	
	/**
	 * Loads the controls for the game.
	 */
	private void loadControls()
	{
		controls = new Controls();
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
	
	/**
	 * creates a new gameManager that runs the game.
	 * @param level the level the user is playing.
	 * @param player the player the user plays with.
	 */
	public static void createGameManager(Level level, Player player)
	{
		gameManager = new GameManager(level, player, window, controls);
	}
	
	/**
	 * If gameManger exists starts the gameManager.
	 * else print out error message.
	 */
	public static void startGameManager()
	{
		if(gameManager != null)
			gameManager.startGame();
		else
			System.out.println("Null Gamemanager");
	}
	
	public static void destroyGameManager()
	{
		gameManager = null;
	}
	
	/*Getters and Setters*/
	public static Controls getControls()
	{
		return controls;
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
	
}
