	 package mainGame;

import java.io.File;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainGame.backend.GameManager;
import map.LevelDesign;
import sound.BackgroundSound;
import sprite.character.enemy.Enemy;
import sprite.character.enemy.EnemyDesign;
import sprite.character.player.Player;
import sprite.character.player.PlayerDesign;
import sprite.item.collectable.Coin;
import sprite.item.collectable.CoinDesign;

/**
 * Run this class to start the Program.
 * @author Sheng 	
 *
 */
public class GameRunner extends Application
{	
	private static Stage window;
	private static GameManager gameManager;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("Little Boy");
		
		Player player = PlayerDesign.getSimpleStarterPlayer("Joy");
		//Enemy[] enemyList= {EnesmyDesign.getRegularDesignOne(500, 500,player),EnemyDesign.getRegularDesignOne(500, 600,player)};
		gameManager = new GameManager(LevelDesign.getLevelDesignOne(), player, window);
		gameManager.startGame();
		
		BackgroundSound bs = new BackgroundSound("resources/music/AlanWForce.mp3", 232);
		bs.playSound(.05);
//		
//		SceneTracker.setWindow(window);
//		
//		Parent mainMenuView = FXMLLoader.load(getClass().getResource("/mainGame/fxmls/MainMenuView.fxml"));
//		SceneTracker.setMainMenuview(mainMenuView);
//		
//		Scene scene = new Scene(SceneTracker.getMainMenuview(), 500, 400);
//		SceneTracker.setScene(scene);
		
		window.setMinHeight(700);
		window.setMinWidth(700);
		window.show();
		
//		List<Coin> coins = CoinDesign.getCoinStack(14);
//		for(Coin coin : coins)
//		{
//			System.out.println(coin);
//		}
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
	
	public static Stage getWindow()
	{
		return window;
	}
	
	public static GameManager getGameManager()
	{
		return gameManager;
	}
}
