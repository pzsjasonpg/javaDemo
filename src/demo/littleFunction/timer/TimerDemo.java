package demo.littleFunction.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Timer�ص㣺
 * 1. �̰߳�ȫ
 */

public class TimerDemo {
	
	//��ʱ����
	//���ͣ�https://www.cnblogs.com/0201zcr/p/4703061.html

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				System.out.println("��ǰʱ�䣺"+sdf.format(new Date()));
				
			}
		}, 3000, 1000);

	}

}
