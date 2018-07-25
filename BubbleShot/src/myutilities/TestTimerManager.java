package myutilities;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimerManager
{
	private static Timer timer;
	private static int counter = 0;
	
	public static void main(String[] args)
	{
		timer = new Timer();
		TimerTask timerTask = new TimerTask()
		{
			public void run()
			{
				counter++;
				System.out.println(counter);
				if(counter == 5)
					try {
						stopTimer();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		};
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
		Timer wakeUpTimer = new Timer();
		wakeUpTimer.schedule(new TimerTask() {public void run() {startTimer();}}, 10000);
	}
	
	public static void stopTimer() throws InterruptedException
	{
		timer.wait();
	}
	
	public static void startTimer()
	{
		timer.notify();
	}
}
