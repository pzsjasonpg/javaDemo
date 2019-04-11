package demo.littleFunction.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args){
		
		//��ȡ��ǰʱ�䣬SimpleDateFormat�����̰߳�ȫ��
		String string = "yyyy-MM-dd HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
		System.out.println(simpleDateFormat.format(new Date()));

		//��String����ת����Date����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		try {
			Date parse = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
