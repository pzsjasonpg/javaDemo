package demo.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			
			
			connection.setRequestProperty("Host", "jwc3.yangtzeu.edu.cn");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			connection.setRequestProperty("Cache-Control", "max-age=0");
			
			connection.connect();
			
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
	
	//获取随机的SHA1密码加密前缀
		public static String getStringFromStream1(InputStream inputStream){
			
			BufferedReader bufferedReader = null;
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					if (line.contains("CryptoJS.SHA1")) {
						String result = line.substring(45, 82);
						return result;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}
	
}
