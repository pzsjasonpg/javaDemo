package demo.collection.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
	
	/*
	 * LinkedHashSet特点：
	 * 1. 按照插入顺序排序
	 * 2. 线程不安全
	 * 3. 元素不重复性
	 * 4. 可以添加null，但是只能有一个
	 */
	
	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		
		//验证输入顺序 and 重复性
		linkedHashSet.add("link");
		linkedHashSet.add("hello");
		linkedHashSet.add("nihao");
		linkedHashSet.add("nihao");
		linkedHashSet.add(null);
		linkedHashSet.add(null);
		
		for (String string : linkedHashSet) {
			System.out.println(string);
		}
		
		//其他方法与HashSet一样
		

		
	}

}
