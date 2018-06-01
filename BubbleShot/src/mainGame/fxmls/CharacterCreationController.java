package mainGame.fxmls;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterCreationController implements Initializable
{
	public ImageView playIconView;
	public TextField playerNameField;
	private int imgIdx;
	private File[] files;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		grabImages();
		displayImage();
	}
	
	private void grabImages()
	{
		File file = new File("resources/player");
		//System.out.println(files.isDirectory());
		files = file.listFiles(new FileFilter() 
		{
			@Override
			public boolean accept(File file)
			{
				String path = file.getPath().toString();
				if(path.substring(path.length() - 3).equals("png"))
					return true;
				return false;
			}
		});
	}
	
	private void displayImage()
	{
		playIconView.setImage(new Image("file:" + files[imgIdx]));
	}
}
