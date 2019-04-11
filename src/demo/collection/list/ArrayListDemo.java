package demo.collection.list;

import java.util.ArrayList;
import java.util.Comparator;

import javax.sound.midi.Soundbank;

public class ArrayListDemo {

	/*
	 * java.util.ArrayList特点：
	 * 1.不是线程安全的；
	 * 2.查询速度快；
	 * 3.插入速度慢；
	 * 4.初始容量为10；
	 * 5.ArrayList以1.5倍的方式在扩容
	 * 
	 */
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<String> arrayListForTest = new ArrayList<String>();
		
		System.out.println("----------添加元素----------");
		//添加元素
		arrayList.add("hello");
		arrayList.add(1, "world");
		arrayListForTest.add("hi");
		arrayListForTest.add("jason");
		arrayList.addAll(arrayListForTest);
		for (String str : arrayList) {
			System.out.println(str);
		}
		
		System.out.println("----------删除元素----------");
		
		//删除元素
		arrayList.remove(1);
		arrayList.removeAll(arrayListForTest);
		for (String str : arrayList) {
			System.out.println(str);
		}
		
		System.out.println("----------修改元素----------");
		
		//修改元素
		arrayList.set(0, "java");
		for (String str : arrayList) {
			System.out.println(str);
		}
		
		System.out.println("---------查找信息-----------");
		
		//查找信息
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		for(int i=10;i>0;i--) {
			arrayList2.add(i);
		}
		int indexOf = arrayList2.indexOf(10);
		boolean contains = arrayList2.contains(1);
		Integer integer = arrayList2.get(1);
		System.out.println(indexOf);
		System.out.println(contains);
		System.out.println(integer);
		
		//排序
		arrayList2.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		for (Integer integer1 : arrayList2) {
			System.out.println(integer1);
		}
		
	}

}
