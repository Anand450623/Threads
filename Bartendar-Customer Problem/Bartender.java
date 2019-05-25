package threads;

import java.util.concurrent.TimeUnit;

public class Bartender implements Runnable
{
	public void run()
	{
		int numTimesWoken = 0;
		
		System.out.println("No one's here, I should sleep");
		
		while (true) 
		{
			if (Thread.interrupted()) 
			{
				System.out.println("Bartendar Woken from sleep");
			}
			
			if (numTimesWoken == 2) 
			{
				break;
			}
			
			try
			{
				TimeUnit.SECONDS.sleep(5);
			}
			catch (InterruptedException e)
			{
				numTimesWoken++;
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println("I'm done for today !!!");
	}
}
