package demo.littleFunction.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Timer特点：
 * 1. 线程安全
 */

public class TimerDemo {
	
	//定时调度
	//博客：https://www.cnblogs.com/0201zcr/p/4703061.html

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				System.out.println("当前时间："+sdf.format(new Date()));
				
			}
		}, 3000, 1000);

	}

}
