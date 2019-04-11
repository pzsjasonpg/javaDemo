package demo.collection.list;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedListDemo {
	
	/*
	 * LinkedList特点：
	 * 1.不是同步的；
	 * 2.插入快
	 * 3.查询慢
	 * 
	 * 
	 */

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		Collection<String> linkedList2 = new LinkedList<String>();
		
		System.out.println("----------添加元素----------");
		
		linkedList.add("link");
		linkedList.add("java");
		linkedList.add("python");
		linkedList.add(0, "c++");
		linkedList.addFirst("c");
		linkedList.addLast("perl");
		
		linkedList2.add("hello");
		linkedList2.add("world");
		linkedList.addAll(linkedList2);
		linkedList.addAll(linkedList.size(), linkedList2);
		//将元素添加到列表末尾
		linkedList.offer("offer");
		linkedList.offerFirst("offerFirst");
		linkedList.offerLast("offerLast");
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		System.out.println("----------删除元素----------");
		linkedList.remove("link");
		linkedList.removeAll(linkedList2);
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		System.out.println("----------修改元素----------");
		linkedList.set(0, "php");
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		System.out.println("---------查找信息-----------");
		String link1 = linkedList.get(0);
		String first = linkedList.getFirst();
		String last = linkedList.getLast();
		System.out.println("link1:"+link1+",first:"+first+",last:"+last);
		
		//查看信息，但是不移除数据
		String peek = linkedList.peek();
		String peekFirst = linkedList.peekFirst();
		String peekLast = linkedList.peekLast();
		System.out.println("peek:"+peek+",peekFirst:"+peekFirst+",peekLast:"+peekLast);
		
		//获取并删除列表数据
		String poll = linkedList.poll();
		String pollFirst = linkedList.pollFirst();
		String pollLast = linkedList.pollLast();
		System.out.println("poll:"+poll+",pollFirst:"+pollFirst+",pollLast:"+pollLast);
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		//从表头增加和删除
		linkedList.push("imastudent");
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		String pop = linkedList.pop();
		System.out.println("pop:"+pop);
		for (String string : linkedList) {
			System.out.println(string);
		}
		

	}

}
