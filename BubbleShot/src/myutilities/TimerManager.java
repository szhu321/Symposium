package myutilities;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


public class TimerManager
{
	public static List<Timeline> timers = new ArrayList<Timeline>();
	public static boolean isPaused = false;
	
	public static void pauseAll()
	{
		for(Timeline timer: timers)
		{
			timer.pause();
		}
		isPaused = true;
	}
	
	public static void resumeAll()
	{
		for(Timeline timer: timers)
		{
			timer.play();
		}
		isPaused = false;
	}
	
	public static void addKeyFrameToNewTimeline(KeyFrame keyframe)
	{
		Timeline tempTimeline = new Timeline();
		tempTimeline.getKeyFrames().add(keyframe);
		tempTimeline.setCycleCount(Timeline.INDEFINITE);
		tempTimeline.playFromStart();
		timers.add(tempTimeline);
	}
}
