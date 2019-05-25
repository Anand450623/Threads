package threads;

import java.util.concurrent.TimeUnit;

public class Customer implements Runnable
{
	private Thread bartenderThread;
	private String name;
	private int waitTime;
	
	public Customer(Thread bartenderThread, String name, int waitTime)
	{
		this.bartenderThread = bartenderThread;
		this.name = name;
		this.waitTime = waitTime;
	}
	
	public void run()
	{
		System.out.println(name + ": Doesn't seem to be anyone around. I'll wait for "+waitTime+" seconds");
		
		try
		{
			TimeUnit.SECONDS.sleep(waitTime);
		}
		catch (InterruptedException e)
		{
			System.out.println(name + ": Bartendar left for the day.!!!");
			return;
		}
		
		System.out.println(name + ": Take my order now");
	
		bartenderThread.interrupt();
	}
}
