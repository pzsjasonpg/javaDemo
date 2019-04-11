package demo.collection.map;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapDemo {
	
	/*
	 * TreeMap的特点：
	 * 1. 线程不安全；
	 * 2. 键不重复；
	 * 3. 键不允许null，值可以为null；
	 * 4. 键是有序的
	 */

	public static void main(String[] args) {
		TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "python");
		treeMap.put(100, "java");
		treeMap.put(4, "php");
		treeMap.put(5, null);
		treeMap.put(33, null);
		//遇到相同的键，下面的会覆盖上面的值
		treeMap.put(100, "ruby");
		
		treeMap.forEach(new BiConsumer<Integer, String>() {

			@Override
			public void accept(Integer t, String u) {
				System.out.println(t.toString() +":"+u);
				
			}
		});

	}

}
