package demo.littleFunction.date;

import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		//��ȡʱ���
		long time = date.getTime();
		System.out.println(time);

		//��ȡʱ���---������
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
		
		//��ȡʱ���
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		System.out.println(timeInMillis);
		
		
	}

}
