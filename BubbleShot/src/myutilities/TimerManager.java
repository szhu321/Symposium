package myutilities;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


public class TimerManager
{
	public static List<Timeline> timers;
	
	public static void pauseAll()
	{
		for(Timeline timer: timers)
		{
			timer.pause();
		}
	}
	
	public static void resumeAll()
	{
		for(Timeline timer: timers)
		{
			timer.play();
		}
	}
	
	public static void addKeyFrameToNewTimeline(KeyFrame keyframe)
	{
		Timeline tempTimeline = new Timeline();
		tempTimeline.getKeyFrames().add(keyframe);
		tempTimeline.playFromStart();
		tempTimeline.setCycleCount(Timeline.INDEFINITE);
		timers.add(tempTimeline);
	}
}
