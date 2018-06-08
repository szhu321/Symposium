package myutilities;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 * This class keeps track of all the timers in the game.
 * New timers can be created and added to this list by calling the 
 * addKeyFrameToNewTimeline() method and passing in a KeyFrame.
 */
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
	}
	
	public static void resumeAll()
	{
		for(Timeline timer: timers)
		{
			timer.play();
		}
	}
	
	public static void stopAll()
	{
		for(Timeline timer: timers)
		{
			timer.stop();
		}
	}
	
	public static void reset()
	{
		timers = new ArrayList<Timeline>();
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
	
	public static void addKeyFrameToNewTimelineNoLoop(KeyFrame keyframe)
	{
		Timeline tempTimeline = new Timeline();
		tempTimeline.getKeyFrames().add(keyframe);
		tempTimeline.playFromStart();
		timers.add(tempTimeline);
	}
}
