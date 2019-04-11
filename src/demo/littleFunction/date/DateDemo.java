package demo.littleFunction.date;

import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		//获取时间戳
		long time = date.getTime();
		System.out.println(time);

		//获取时间戳---这个最好
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		
		//获取时间戳
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		System.out.println(timeInMillis);
		
		
	}

}
