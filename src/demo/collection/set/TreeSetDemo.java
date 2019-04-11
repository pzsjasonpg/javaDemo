package demo.collection.set;

import java.util.TreeSet;

import demo.collection.set.comparator.MyComparator;

public class TreeSetDemo {
	
	/*
	 * TreeSet特点：
	 * 1. 线程不安全
	 * 2. 有序集合（对元素自然排序）
	 * 
	 */
	
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		System.out.println("----------添加元素----------");
		//并验证有序
		treeSet.add(100);
		treeSet.add(23);
		treeSet.add(33);
		treeSet.add(11);
		treeSet.add(15);
		for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		
		System.out.println("----------删除元素----------");
		treeSet.remove(15);
		//返回并删除该元素
		Integer pollFirst = treeSet.pollFirst();
		Integer pollLast = treeSet.pollLast();
		for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		
		System.out.println("----------比该元素大或小的元素----------");
		//返回此 set 中严格大于给定元素的最小元素；如果不存在这样的元素，则返回 null。
		Integer higher = treeSet.higher(15);
		System.out.println(higher);
		//返回此 set 中严格小于给定元素的最大元素；如果不存在这样的元素，则返回 null。
		Integer lower = treeSet.lower(23);
		System.out.println(lower);
		//返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。
		Integer floor = treeSet.floor(23);
		System.out.println(floor);
		
		//验证排序
		System.out.println("-------------验证排序-----------------");
		MyComparator myComparator = new MyComparator();
		TreeSet<Integer> treeSet2 = new TreeSet<Integer>(myComparator);
		treeSet2.add(23);
		treeSet2.add(45);
		treeSet2.add(1);
		for (Integer integer : treeSet2) {
			System.out.println(integer);
		}
		
		
	}

}
