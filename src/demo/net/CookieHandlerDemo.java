package demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


/**
 *	鍏充簬http杩囩▼涓璫ookie鐨刣emo
 * @author 28256
 * 模拟登录长大教务处失败
 */
public class CookieHandlerDemo {
	
	
	public static void main(String[] args) {
		
		String path = "http://jwc3.yangtzeu.edu.cn/eams/login.action";
		
		InputStream inputStream = null;
		
		String sha1Prefix = getSHA1Prefix(path);
		System.out.println("鍓嶇紑锛�"+sha1Prefix);
		try {
			URL url = new URL(path);
			
			//閫氳繃URL鑾峰彇杩炴帴瀵硅薄
			HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
			//璁剧疆杩炴帴鍙傛暟
			connection1.setRequestMethod("POST");
			connection1.setConnectTimeout(10000);
			
			//1. 璁剧疆璇锋眰澶�
			setRequestHeaderInLoginPage(connection1);
				
			//2. 鑾峰彇鍝嶅簲澶寸殑cookie锛屽嵆key涓衡�渟et-cookie鈥濓紝骞朵繚瀛橈紝
			CookieManager cookieManager = new CookieManager();
			URI uri = url.toURI();
			//寰楀埌鍝嶅簲澶�
			Map<String, List<String>> headerFields = connection1.getHeaderFields();
			cookieManager.put(uri, headerFields);
				
			//3. 灏哻ookie鍏跺湪鎻愪氦鐢ㄦ埛鍚嶅拰瀵嗙爜鏃讹紝鎻愪氦缁欐湇鍔″櫒
			String sendPost = sendPost(connection1,path, "username="+sha1Prefix+"201501607&password=201501607");
			System.out.println(sendPost);
				
			
			
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
		
		
		
		/*
		 * try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(10000);
			
			
			//1. 璁剧疆璇锋眰澶�
			setRequestHeaderInLoginPage(connection);
			
			//2. 鑾峰彇鍝嶅簲澶寸殑cookie锛屽嵆key涓衡�渟et-cookie鈥濓紝骞朵繚瀛橈紝
			CookieManager cookieManager = new CookieManager();
			URI uri = url.toURI();
			//寰楀埌鍝嶅簲澶�
			Map<String, List<String>> headerFields = connection.getHeaderFields();
			cookieManager.put(uri, headerFields);
			
			//3. 灏哻ookie鍏跺湪鎻愪氦鐢ㄦ埛鍚嶅拰瀵嗙爜鏃讹紝鎻愪氦缁欐湇鍔″櫒
			String sendPost = sendPost(connection, "username=201501607&password=201501607");
//			System.out.println(sendPost);
			
			//3.1 澶勭悊杞彂缃戝潃
			HttpURLConnection Transmitonnection = (HttpURLConnection) url.openConnection();
			setRequestHeaderInTransmit(Transmitonnection);
			

			
			//4. 鑾峰彇淇℃伅
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*/

	}
	
	/**
	 * 
	 * @param url
	 * @return SHA1瀵嗙爜鍓嶇紑
	 */
	public static String getSHA1Prefix(String path) {
		InputStream inputStream = null;
		try {
			URL url = new URL(path);
			//閫氳繃URL鑾峰彇杩炴帴瀵硅薄
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//璁剧疆杩炴帴鍙傛暟
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			//鑾峰緱鍝嶅簲淇℃伅
			int code = connection.getResponseCode();
		
		
			if (code == 200) {
				//寰楀埌杈撳叆娴侊紝鑾峰緱鏂囦欢鏁版嵁骞舵樉绀�
				inputStream = connection.getInputStream();
				String result = getStringFromStream(inputStream);
				
				return result;
			} 
		}catch (Exception e) {
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
		return null;
		}
	
	
	/**
	 * 璁剧疆璇锋眰澶村湪鐧诲綍椤甸潰
	 */
	public static void setRequestHeaderInLoginPage(URLConnection connection) {
		
//		Host: jwc3.yangtzeu.edu.cn
//		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0
//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//		Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//		Accept-Encoding: gzip, deflate
//		Referer: http://jwc3.yangtzeu.edu.cn/eams/home.action
//		Connection: keep-alive
//		Cookie: JSESSIONID=663968AE43A2DA45345430EC06CC1CEB.node131; adc-ck-jwxt_pools=IDALAKAK; GSESSIONID=663968AE43A2DA45345430EC06CC1CEB.node131
//		Upgrade-Insecure-Requests: 1
//		Cache-Control: max-age=0
		
		//setRequestProperty鏂规硶鏄湁鐩稿悓鐨刱ey鏃惰鐩栵紝addRequestProperty鏂规硶鏄笉瑕嗙洊
		connection.setRequestProperty("Host", "jwc3.yangtzeu.edu.cn");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
		connection.setRequestProperty("Referer", "http://jwc3.yangtzeu.edu.cn/eams/home.action");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Cookie", "JSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; GSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; adc-ck-jwxt_pools=IDALAKAK");
		connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
		connection.setRequestProperty("Cache-Control", "max-age=0");
	}
	
	
	
	//鑾峰彇闅忔満鐨凷HA1瀵嗙爜鍔犲瘑鍓嶇紑
	public static String getStringFromStream(InputStream inputStream){
		
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
	
	/**
	 * 鍦ㄨ浆鍙戦〉闈㈣缃姹傚ご
	 */
	public static void setRequestHeaderInTransmit(HttpURLConnection connection) {
//		Host: jwc3.yangtzeu.edu.cn
//		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0
//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//		Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//		Accept-Encoding: gzip, deflate
//		Referer: http://jwc3.yangtzeu.edu.cn/eams/login.action
//		Content-Type: application/x-www-form-urlencoded
//		Content-Length: 106
//		Connection: keep-alive
//		Cookie: JSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; GSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; adc-ck-jwxt_pools=IDALAKAK
//		Upgrade-Insecure-Requests: 1
		
		
		
		//setRequestProperty鏂规硶鏄湁鐩稿悓鐨刱ey鏃惰鐩栵紝addRequestProperty鏂规硶鏄笉瑕嗙洊
		connection.setRequestProperty("Host", "jwc3.yangtzeu.edu.cn");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
		connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
		connection.setRequestProperty("Referer", "http://jwc3.yangtzeu.edu.cn/eams/login.action");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Length", "106");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Cookie", "JSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; GSESSIONID=C4EBA0DA4B0697A55D85EC14FF69947D.node131; adc-ck-jwxt_pools=IDALAKAK");
		connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
	}
	
	/**
	 * 鍦ㄧ櫥褰曠晫闈㈢粰鏈嶅姟鍣ㄥ彂閫佺敤鎴峰悕鍜屽瘑鐮�
	 */
	public static String sendPost(HttpURLConnection conn, String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
        		
        	//璁剧疆璇锋眰澶�
        	setRequestHeaderInLoginPage(conn);
        	
        	conn.setDoInput(true);
        	conn.setDoOutput(true);
            //1.鑾峰彇URLConnection瀵硅薄瀵瑰簲鐨勮緭鍑烘祦
            out = new PrintWriter(conn.getOutputStream());
            //2.涓枃鏈変贡鐮佺殑闇�瑕佸皢PrintWriter鏀逛负濡備笅
            //out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")
            // 鍙戦�佽姹傚弬鏁�
            out.print(param);
            // flush杈撳嚭娴佺殑缂撳啿
            out.flush();
            // 瀹氫箟BufferedReader杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
//                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("鍙戦�� POST 璇锋眰鍑虹幇寮傚父锛�"+e);
            e.printStackTrace();
        }
        //浣跨敤finally鍧楁潵鍏抽棴杈撳嚭娴併�佽緭鍏ユ祦
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("post鎺ㄩ�佺粨鏋滐細"+result);
        return result;
	}
	
	
}


