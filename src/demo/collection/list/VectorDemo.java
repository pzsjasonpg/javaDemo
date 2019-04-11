package demo.collection.list;

import java.security.KeyStore.CallbackHandlerProtection;
import java.util.Vector;

import javax.lang.model.element.Element;


public class VectorDemo {
	
	/*
	 * Vector特点：
	 * 1. 同步的；
	 * 2.查询速度快；
	 * 3.插入速度慢；
	 * 4.初始容量为10；
	 * 5.Vector 当扩容容量增量大于0时、新数组长度为原数组长度+扩容容量增量、否则新数组长度为原数组长度的2倍
	 */
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		
		
		System.out.println("----------添加元素----------");
		for (int i = 0; i < 11; i ++) {
			vector.add("str"+i);
		}
		vector.addElement("Element");
		for (String string : vector) {
			System.out.println(string);
		}
		
		System.out.println("----------删除元素----------");
		String remove = vector.remove(0);
		boolean remove2 = vector.remove("str1");
		boolean removeElement = vector.removeElement("str2");
		for (String string : vector) {
			System.out.println(string);
		}
		
		System.out.println("----------修改元素----------");
		String set = vector.set(0, "hello");
		vector.setElementAt("world", 1);
		vector.setSize(20);
		for (String string : vector) {
			System.out.println(string);
		}
		
		
		System.out.println("---------查找信息-----------");
		int capacity = vector.capacity();
		System.out.println(capacity);
		
		//clone方法如果修改源对象，那么克隆对象也会变；但是如果只修改clone对象，源对象则不变。
//		vector.setElementAt("peng", 3);
		Vector<String> clone = (Vector<String>) vector.clone();
		clone.setElementAt("jaan", 4);
		for (String string : vector) {
			System.out.println(string);
		}
		
		
	}

}
