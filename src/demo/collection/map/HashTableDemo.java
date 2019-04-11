package demo.collection.map;

import java.util.Hashtable;
import java.util.function.BiConsumer;

public class HashTableDemo {
	
	/*
	 * HashTable的特点：
	 * 1. 线程安全；
	 * 2. 不允许任何的null键和null值；
	 * 3. 无序
	 * 4. 默认是11的初始容量，加载因子0.75；
	 */

	public static void main(String[] args) {
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("1", "java");
		hashtable.put("2", "python");
		hashtable.put("3", "php");
		hashtable.forEach(new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.println(t+":"+u);
				
			}
		});
		
		

	}

}
