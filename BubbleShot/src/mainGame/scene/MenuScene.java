package mainGame.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MenuScene
{
	private Scene scene;
	private BorderPane layout;
	
	private Button playBtn;
	private Button mapEditorBtn;
	private Button settingsBtn;
	private Button QuitBtn;
	
	public MenuScene()
	{
		loadMenu();
		scene = new Scene(layout, 700, 700);
	}
	
	public void loadMenu()
	{
		layout = new BorderPane();
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
		layout.setCenter(btnContainer);
		
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

	public Scene getScene()
	{
		return scene;
	}
}
