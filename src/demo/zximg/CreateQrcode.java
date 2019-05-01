package demo.zximg;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 生成二维码
 * @author 28256
 *
 */
public class CreateQrcode {

	public static void main(String[] args) {
		
		
		QRcodeUtil qRcodeUtil = new QRcodeUtil();

		//5s后执行，每隔5s刷新二维码
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String format = simpleDateFormat.format(new Date());
				
				String urlAndTime = "http://www.baidu.com"+"####"+format;
				qRcodeUtil.createQRcodeImage(urlAndTime,"C:\\Users\\28256\\Pictures\\Saved Pictures\\img.png");
				
			}
		}, 5000,5000);
		
	}
	

}
