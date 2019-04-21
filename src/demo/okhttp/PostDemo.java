package demo.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * post请求：
 * 1.创建OkHttpClient客户端.
	2.创建Request请求,设置url.
	3.通过OkHttpClient的newCall()方法,将Request包装成一个Call接口.
	4.最后调用execute()方法得到同步的响应Response.
	5.或者调用execute()方法,以CallBack回调接口作为参数,得到异步的响应Response.
	
	流程和GET请求类似.
	不同的地方在于:
	1.需要RequestBody请求体封装各种类型的请求参数.
	2.调用Request.Builder的post()方法，传入RequestBody,设置为POST请求
 * @author 28256
 *
 */
public class PostDemo {
	
	public static void main(String[] args) {
		
		String url = "http://jwc3.yangtzeu.edu.cn/eams/login.action";
		//请求
		OkHttpClient client = new OkHttpClient();
		//表单
		FormBody requestBody = new FormBody.Builder()
		.add("username", "201501607")
		.add("password", "201501607")
		.add("encodedPassword", "")
		.add("session_locale", "zh_CN")
		.build();
		
		Request request = new Request.Builder().url(url).post(requestBody).build();
		Call call = client.newCall(request);
		
		try {
			//同步请求
//			Response response = call.execute();
//			String string = response.body().string();
//			System.out.println(string);
			
			//异步请求
			call.enqueue(new Callback() {
				
				@Override
				public void onResponse(Call arg0, Response arg1) throws IOException {
					System.out.println("异步请求响应成功");
				}
				
				@Override
				public void onFailure(Call arg0, IOException arg1) {
					System.out.println("异步请求失败");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
