package threads.creating.managing;

import java.util.concurrent.TimeUnit;

public class Kenny implements Runnable
{
	public void run()
	{
		System.out.println("Hello World!");

		Thread currentThread = Thread.currentThread();
			
		while (!currentThread.isInterrupted())
		{
			System.out.println("I'm still alive!");
			
			try
			{
				TimeUnit.MILLISECONDS.sleep(500);
			}
			catch (InterruptedException e)
			{
				System.out.println("current thread interrupted");
				currentThread.interrupt();
			}
		}
		
		System.out.println("Throwing exception");
		throw new RuntimeException("Goodbye cruel World!");
	}
}
