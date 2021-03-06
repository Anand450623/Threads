package threads;

import java.util.concurrent.TimeUnit;

public class Main 
{
	public static void main(String args[])
	{
		Bartender bartender = new Bartender();
		Thread bartenderThread = new Thread(bartender, "Bartender");
		
		bartenderThread.start();
		
		// Giving Initial 1 second sleep to bartender
		try
		{
			TimeUnit.SECONDS.sleep(1);
		}
		catch (InterruptedException e)
		{
			// This can be ignored
		}
		
		int numCustomers = 5;
		
		Thread[] customerThreads = new Thread[numCustomers];
		
		for (int i=1; i<=numCustomers; i++) 
		{
			String customerName = "Customer " + i;
			Customer customer = new Customer(bartenderThread, customerName, (int) (Math.random() * 10));
		
			customerThreads[i-1] = new Thread(customer, customerName);
			customerThreads[i-1].start();
		}
		
		
		try
		{
			bartenderThread.join();
		}
		catch (InterruptedException e)
		{
			// TODO -- for later implementation
		}
		
		System.out.println("Bartendar: I have worked enough today, I should leave !!!");
		
		for (int i=1; i<=numCustomers; i++) 
		{
			customerThreads[i-1].interrupt();
		}
		
	}
	
}
