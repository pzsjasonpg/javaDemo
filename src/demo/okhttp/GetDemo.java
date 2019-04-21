package demo.okhttp;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp的get方法流程
 * 1.创建OkHttpClient客户端.
	2.创建Request请求,设置url.
	3.通过OkHttpClient的newCall()方法,将Request包装成一个Call接口.
	4.最后调用execute()方法得到同步的响应Response.
	5.或者调用execute()方法,以CallBack回调接口作为参数,得到异步的响应Response.
 * @author 28256
 *
 */
public class GetDemo {
	
	public static void main(String[] args) {
		
		String url = "http://jwc3.yangtzeu.edu.cn/eams/login.action";
		
		//GET请求
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("http://www.baidu.com")
				.build();
		Call call = client.newCall(request);
		try {
//			//同步请求
//			Response response = call.execute();
//			//获取不同的响应数据
//			//字符串，如JSON
//			String string = response.body().string();
//			
//			//byte,如Bitmap
//			byte[] bytes = response.body().bytes();
//			//IO流，如文件
//			InputStream inputStream = response.body().byteStream();
			
			//异步请求
			call.enqueue(new Callback() {
				//请求成功，回调
				@Override
				public void onResponse(Call arg0, Response arg1) throws IOException {
					System.out.println("响应成功");
				}
				//请求失败，回调
				@Override
				public void onFailure(Call arg0, IOException arg1) {
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
