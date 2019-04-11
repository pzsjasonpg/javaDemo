package demo.net;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


/**
 * 	获取网站HTML网页文件
 * @author 28256
 *
 */
public class URLConnectionDemo {

	public static void main(String[] args) {
		String path = "http://jwc3.yangtzeu.edu.cn/eams/login.action";
		
		InputStream inputStream = null;
		
		try {
			URL url = new URL(path);
			//通过URL获取连接对象
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//设置连接参数
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			//获得响应信息
			int code = connection.getResponseCode();
			
			if (code == 200) {
				//得到输入流，获得文件数据并显示
				inputStream = connection.getInputStream();
				String result = getStringFromStream(inputStream);
				System.out.println(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	public static String getStringFromStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream baso = new ByteArrayOutputStream();
		int len = -1;
		byte[] buffer = new byte[1024];
			while((len = inputStream.read(buffer))!=-1){
				baso.write(buffer, 0, len);
			}
			inputStream.close();
			byte[] byteArray = baso.toByteArray();
			return new String(byteArray);
	}
}
