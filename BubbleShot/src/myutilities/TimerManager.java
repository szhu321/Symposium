package myutilities;

import java.util.List;
import java.util.Timer;

import javafx.animation.Timeline;


public class TimerManager
{
	private List<Timeline> timers;
	
	public TimerManager()
	{
		
	}
	
	public void pauseAll()
	{
		for(Timeline timer: timers)
		{
			timer.pause();
		}
	}
	
	public void resumeAll()
	{
		for(Timeline timer: timers)
		{
			timer.play();
		}
	}
}
