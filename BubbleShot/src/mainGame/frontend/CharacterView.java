package mainGame.frontend;

import javafx.scene.canvas.Canvas;
import sprite.character.Character;

public class CharacterView 
{
	private Canvas canvas;
	private Character character;
	
	public CharacterView()
	{
		canvas = new Canvas();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	
}
