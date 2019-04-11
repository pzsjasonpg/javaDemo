package demo.littleFunction.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args){
		
		//获取当前时间，SimpleDateFormat不是线程安全的
		String string = "yyyy-MM-dd HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
		System.out.println(simpleDateFormat.format(new Date()));

		//将String类型转换成Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		try {
			Date parse = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
