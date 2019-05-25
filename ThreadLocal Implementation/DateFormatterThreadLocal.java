package threads.creating.managing;

import java.text.SimpleDateFormat;

public class DateFormatterThreadLocal extends ThreadLocal<SimpleDateFormat> 
{
	protected SimpleDateFormat initialValue() 
	{
		return new SimpleDateFormat("EEE MMM d, hh:mm:ss");
	}
}
