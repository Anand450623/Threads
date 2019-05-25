package threads.creating.managing;

public class DateFormatterExample
{
	
	public static DateFormatterThreadLocal dateFormatterVar = new DateFormatterThreadLocal();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new DatePrinter("Formatter 1"), "Formatter 1");
		Thread t2 = new Thread(new DatePrinter("Formatter 2"), "Formatter 2");
		
		t1.start();
		t2.start();
	}
}