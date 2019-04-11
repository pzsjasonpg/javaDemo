package demo.collection.map;

import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class LinkedHashMapDemo {
	
	/*
	 * LinkedHashMap的特点：
	 * 1. 线程不安全；
	 * 2. 按照输入顺序排序
	 * 3. 允许多个null键和null值；
	 * 4. 默认是16的初始容量，加载因子0.75；
	 */

	public static void main(String[] args) {
		
		LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();
		linkedHashMap.put("11", "java");
		linkedHashMap.put("2","php");
		linkedHashMap.put("3", "python");
		linkedHashMap.forEach(new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.println(t+":"+u);
				
			}
		});
		
		//除了输入有序外其他方法与HashMap相同

	}

}
