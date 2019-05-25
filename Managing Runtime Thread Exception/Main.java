package threads.creating.managing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main
{
	public static void main(String[] args)
	{
		Kenny kenny = new Kenny();

		System.out.println("Starting Kenny");

		Thread t = new Thread(kenny, "Kenny");

		ThreadExceptionHandler exceptionHandler = new ThreadExceptionHandler();
		t.setUncaughtExceptionHandler(exceptionHandler);

		t.start();

		try
		{
			TimeUnit.SECONDS.sleep(2);
		}
		catch (InterruptedException e)
		{
			// Can ignore
		}
		
		t.interrupt();
		
		try
		{
			t.join();
		}
		catch (InterruptedException e)
		{
			System.out.println("Inside join catch block");
			// Ignore
		}
		
		ExecutionException exception = exceptionHandler.getException();
		
		System.out.println("They killed Kenny process!");
		
		if (exception != null)
		{
			System.out.println("Thread caught an exception");
			exception.printStackTrace();
		}
	}
}
