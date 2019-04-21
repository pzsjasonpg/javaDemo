package demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 尝试模拟登录长大失败
 */
public class CookieDemo {
	
	private static String url = "http://jwc3.yangtzeu.edu.cn/eams/login.action";
	static HttpURLConnection conn = null;
	


	public static void main(String[] args) {
		
		String username = "201501607";
		String password = "201501607";
		
		sendPost(url, username, password);
		

	}
	
    /**
     * 	向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static void sendPost(String url, String username, String password)  {
    	
    	String params = null;
    	String param = "username="+username+"&password=";
        
    	// 定义BufferedReader输入流来读取URL的响应
        
        
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(10000);
            // 设置通用的请求属性
          //setRequestProperty方法是有相同的key时覆盖，addRequestProperty方法是不覆盖
            conn.setRequestProperty("Host", "jwc3.yangtzeu.edu.cn");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("Cache-Control", "max-age=0");
            
            
            
            // 发送POST请求必须设置如下两行
            
            conn.setDoOutput(true);
            conn.setDoInput(true);
            InputStream inputStream = null;
			BufferedReader in = null;
			try {
				inputStream = conn.getInputStream();
				in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
				String line = "";
				System.out.println("------------------post获取前缀----------------------");
				while ((line = in.readLine()) != null) {
					System.out.println(line);
					if (line.contains("CryptoJS.SHA1")) {
						String passwdPrefix = line.substring(45, 82);
						String sha1Password = DigestUtils.sha1Hex(passwdPrefix+password);
						System.out.println("加密后的密码；"+sha1Password);
						params = param+sha1Password+"&encodedPassword="+""+"&session_locale=zh_CN";
						System.out.println(params);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			
			
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					synchronized (conn) {
						PrintWriter out = null;
						//1.获取URLConnection对象对应的输出流
			            try {
			            	System.out.println("------------------post发送用户密码----------------------");
							out = new PrintWriter(conn.getOutputStream());
							//2.中文有乱码的需要将PrintWriter改为如下
				            //out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")
				            // 发送请求参数
//				            out.print(params);
				            // flush输出流的缓冲
				            out.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							if(out!=null){
			                    out.close();
			                }
						}
					}
				}
			}).start();
              
            
            
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        
    }
    
    /**
     * 	向指定URL发送GET方法的请求
     * 
     * @param url
     *            	发送请求的URL
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader bufferedReader = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            // 设置通用的请求属性
            connection.setRequestProperty("Host", "jwc3.yangtzeu.edu.cn");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.setRequestProperty("Referer", "http://jwc3.yangtzeu.edu.cn/eams/home.action");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Cookie", "JSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; GSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; adc-ck-jwxt_pools=IDALAKAK");
            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestProperty("Cache-Control", "max-age=0");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("CryptoJS.SHA1")) {
					result = line.substring(45, 82);
					return result;
				}
			}
           
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (bufferedReader != null) {
                	bufferedReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


    
    

}
