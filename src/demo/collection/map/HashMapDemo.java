package demo.collection.map;

import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;

public class HashMapDemo {
	
	/*
	 * HashMap的特点：
	 * 1. 线程不安全；
	 * 2. 元素没有顺序，是无序的；
	 * 3. 允许多个null值存在， 但是只允许1个null键存在；
	 * 4. 默认是16的初始容量，加载因子0.75；
	 */

	public static void main(String[] args) {
		
		HashMap<String,String> hashMap = new HashMap<String,String>();
		
		System.out.println("----------添加元素----------");
		hashMap.put("1", "java");
		hashMap.put("2", "php");
		hashMap.put("3", "python");
		
		Set<String> keySet = hashMap.keySet();
		for (String string : keySet) {
			System.out.println(string +":"+ hashMap.get(string));
		}
		
		System.out.println("----------删除元素----------");
		String remove = hashMap.remove("1");
		for (String string : keySet) {
			System.out.println(string +":"+ hashMap.get(string));
		}
		
		System.out.println("----------修改元素----------");
		hashMap.replace("2", "php", "ruby");
		for (String string : keySet) {
			System.out.println(string +":"+ hashMap.get(string));
		}
		
		System.out.println("---------查找信息-----------");
		String string = hashMap.get("2");
		System.out.println(string);
		
		int size = hashMap.size();
		System.out.println(size);
		
		//打印键值对
		hashMap.forEach(new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				System.out.println(t+":"+u);
				
			}
		});

	}

}
