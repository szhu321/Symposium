package mainGame.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScene
{
	private Scene menuScene;
	private BorderPane menuScenelayout;
	private Button playBtn;
	private Button mapEditorBtn;
	private Button settingsBtn;
	private Button QuitBtn;
	
	private Stage window;
	
	private BorderPane characterCreationPage;
	
	
	public MenuScene(Stage window)
	{
		loadMenu();
		menuScene = new Scene(menuScenelayout, 700, 700);
		this.window = window;
		window.setScene(menuScene);
	}
	
	public void loadMenu()
	{
		menuScenelayout = new BorderPane();
		loadButtons();
	}
	
	public void loadButtons()
	{
		playBtn = new Button("Play");
		mapEditorBtn = new Button("Map Editor");
		settingsBtn = new Button("Settings");
		QuitBtn = new Button("Quit");
		
		VBox btnContainer = new VBox(50);
		btnContainer.setAlignment(Pos.CENTER);
		
		btnContainer.getChildren().addAll(playBtn, mapEditorBtn, settingsBtn, QuitBtn);
		menuScenelayout.setCenter(btnContainer);
		
		playBtn.setOnAction(event -> 
		{
			
		});
		
		mapEditorBtn.setOnAction(event -> 
		{
			
		});
		
		settingsBtn.setOnAction(event -> 
		{
			
		});
		
		QuitBtn.setOnAction(event -> 
		{
			
		});
	}

	public Scene getMenuScene()
	{
		return menuScene;
	}
}
