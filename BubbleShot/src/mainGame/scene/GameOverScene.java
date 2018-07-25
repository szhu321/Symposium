package mainGame.scene;

import java.awt.Font;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameOverScene
{
	private Scene scene;
	private Button menuButton;
	private Button restartButton; 
	private Group root;
	
	public void scene()
	{
		scene = new Scene(root);
	}
	public void menuButton()
	{
		menuButton =  new Button("Go To Main Menu");
	}
	
	public void restartButton()
	{
		restartButton =   new Button("Restart Game");
	}
	
	public void GameOverScene(Stage theStage)
	{
		theStage.setTitle( "Canvas Example" );
		root = new Group();
		theStage.setScene( scene );
		theStage.show();
		/*
		Pane canvas = new Pane(); 
        canvas.setStyle("-fx-background-color: black;"); 
        canvas.setPrefSize(200, 200); // set size of pane
        Font f = Font.font("Times New Roman", FontWeight.BOLD, 35);

		BorderPane root = new BorderPane();
		root.getChildren().add(canvas);
		 scene = new Scene(root,500, 500); 
	    //stage.setTitle("Game Over!");
	   // stage.setScene(scene);
	   // stage.show();*/
	}
}