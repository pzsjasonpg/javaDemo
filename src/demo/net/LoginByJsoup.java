package demo.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class LoginByJsoup {
	
	public static void main(String[] args) throws IOException {
		LoginByJsoup loginByJsoup = new LoginByJsoup();
		loginByJsoup.login("201501607", "201501607");
		
	}
	
	public void login(String userName, String password) throws IOException {
		String url = "http://jwc3.yangtzeu.edu.cn/eams/login.action";
		Connection connect = Jsoup.connect(url);
		Map<String, String> header = new HashMap<String, String>();
		
//		请求头
//		Host: jwc3.yangtzeu.edu.cn
//		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0
//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//		Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//		Accept-Encoding: gzip, deflate
//		Connection: keep-alive
//		Upgrade-Insecure-Requests: 1
//		Cache-Control: max-age=0
		
		header.put("Host", "jwc3.yangtzeu.edu.cn");
		header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
		header.put("Connection", "keep-alive");
		header.put("Cache-Control", "max-age=0");
		
		connect.headers(header);
		Response execute = connect.execute();
		//获取cookie
		Map<String, String> cookies = execute.cookies();
		System.out.println(cookies);
		//获取响应头
		Map<String, String> headers = execute.headers();
		System.out.println(headers);
		//获取密码前缀---随机字符串
		Document document = execute.parse();
		Elements select = document.select("body > script:nth-child(7)");
		String trim = select.toString().trim();
		String rex = "CryptoJS.SHA1[(]\\'(.*?)\\'";
		Pattern compile = Pattern.compile(rex);
		Matcher matcher = compile.matcher(trim);
		boolean find = matcher.find();
		//group是密码前缀
		String group = null;
		if (find) {
			group = matcher.group(1);
		}
		
		//对密码SHA1加密
		String pw = DigestUtils.sha1Hex(group+password);
//		System.out.println(pw);
//		System.out.println(pw.length());
		
		//表单数据
		Map<String,String> formDatas = new HashMap<String,String>();
		formDatas.put("username", userName);
		formDatas.put("password", pw);
		formDatas.put("encodedPassword", "");
		formDatas.put("session_locale", "zh_CN");
		
		//表单数据长度
		String formStr = "username="+userName+"&password="+pw+"&encodedPassword="+"&session_locale=zh_CN";
		int formLength = formStr.length();
		
		
		Connection connect2 = Jsoup.connect(url);
		Map<String, String> header2 = new HashMap<>();
		header2.put("Host", "jwc3.yangtzeu.edu.cn");
		header2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0");
		header2.put("Connection", "keep-alive");
		header2.put("Cache-Control", "max-age=0");
		header2.put("Referer", "http://jwc3.yangtzeu.edu.cn/eams/home.action");
		header2.put("Content-Length", formLength+"");
		connect2.headers(header2);
		connect2.ignoreContentType(true).method(Method.POST).timeout(10000);
		connect2.cookies(cookies);
		connect2.data(formDatas);
		Response response = connect2.execute();
//		System.out.println(response.parse());
		Document document2 = response.parse();
		System.out.println(document2);
		
		
		
		
		
		
		
		
		//设置表单数据
//		Elements formSelect = document.select("#loginForm");
//		for (Element element : formSelect) {
//			if (element.attr("name").equals("username")) {
//				element.attr("value", userName);
//			}
//			if (element.attr("name").equals("password")) {
//				element.attr("value", password);
//			}
//			if (element.attr("name").equals("session_locale")) {
//				element.attr("value", "zh_CN");
//			}
//			
//		}
		
		
		
		
	}

}
