package sound;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundEffects
{
	/*Background Music*/
	public static final BackgroundSound OLD_GAME_MUSIC = new BackgroundSound("resources/music/OldGameMusic.mp3");
	public static final BackgroundSound FUNKY_GAME_MUSIC = new BackgroundSound("resources/music/FunkyGameMusic.mp3");
	public static final BackgroundSound NICE_GAME_MUSIC = new BackgroundSound("resources/music/NiceGameMusic.mp3");
	
	
	/*Sound Effects*/
	public static final EffectSound GUN_SHOT_SOUND = new EffectSound("resources/soundEffects/gunShot.mp3");
	public static final EffectSound MENU_SELECT_SOUND = new EffectSound("resources/soundEffects/MenuSelectSound.mp3");
	public static final EffectSound PEW_PEW_SOUND = new EffectSound("resources/soundEffects/pew_pew.mp3");
	public static final EffectSound MOUSE_CLICK_SOUND = new EffectSound("resources/soundEffects/MouseClick.mp3");
	public static final EffectSound PICK_UP_ITEM_SOUND = new EffectSound("resources/soundEffects/PickUpItemSound.mp3");
	public static final EffectSound PICK_UP_ITEM_2_SOUND = new EffectSound("resources/soundEffects/PickUpItem2Sound.mp3");
	public static final EffectSound SWORD_SWING_SOUND = new EffectSound("resources/soundEffects/SwordSwingSound.mp3");
	public static final EffectSound WALKING_SOUND = new EffectSound("resources/soundEffects/WalkingSound.mp3");
	public static final EffectSound STOMPING_SOUND = new EffectSound("resources/soundEffects/StompingSound.mp3");
	public static final EffectSound RUNNING_SOUND = new EffectSound("resources/soundEffects/RunningSound.mp3");
	
	/*Main Menu Video*/
	public static final MediaPlayer MENU_BACKGROUND_VID = new MediaPlayer(new Media(new File("resources/background/MainMenuBackgroundVid.mp4").toURI().toString()));
}
