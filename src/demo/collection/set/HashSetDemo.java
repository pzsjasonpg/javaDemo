package demo.collection.set;

import java.util.HashSet;

public class HashSetDemo {
	
	/*
	 * HashSet特点：
	 * 1. 无序性
	 * 2. 不重复性
	 * 3. 泛型是String类型的可以插入null
	 * 4. 线程不安全
	 */
	
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(12);
		hashSet.add(1);
		hashSet.add(55);
		hashSet.add(45);
		
		for (Integer integer : hashSet) {
			System.out.println(integer.intValue());
		}
		
		//验证插入null
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("hello");
		hashSet1.add("world");
		hashSet1.add("nihao");
		hashSet1.add(null);
		hashSet1.add(null);
		
		for (String integer : hashSet1) {
			System.out.println(integer);
		}
		
		System.out.println("----------添加元素----------");
		hashSet1.add("peng");
		for (String integer : hashSet1) {
			System.out.println(integer);
		}
		
		System.out.println("----------删除元素----------");
		hashSet1.remove("nihao");
		for (String integer : hashSet1) {
			System.out.println(integer);
		}
		
		
		
	}

}
