package demo.collection.list;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedListDemo {
	
	/*
	 * LinkedList�ص㣺
	 * 1.����ͬ���ģ�
	 * 2.�����
	 * 3.��ѯ��
	 * 
	 * 
	 */

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		Collection<String> linkedList2 = new LinkedList<String>();
		
		System.out.println("----------���Ԫ��----------");
		
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
		//��Ԫ����ӵ��б�ĩβ
		linkedList.offer("offer");
		linkedList.offerFirst("offerFirst");
		linkedList.offerLast("offerLast");
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		System.out.println("----------ɾ��Ԫ��----------");
		linkedList.remove("link");
		linkedList.removeAll(linkedList2);
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		System.out.println("----------�޸�Ԫ��----------");
		linkedList.set(0, "php");
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		System.out.println("---------������Ϣ-----------");
		String link1 = linkedList.get(0);
		String first = linkedList.getFirst();
		String last = linkedList.getLast();
		System.out.println("link1:"+link1+",first:"+first+",last:"+last);
		
		//�鿴��Ϣ�����ǲ��Ƴ�����
		String peek = linkedList.peek();
		String peekFirst = linkedList.peekFirst();
		String peekLast = linkedList.peekLast();
		System.out.println("peek:"+peek+",peekFirst:"+peekFirst+",peekLast:"+peekLast);
		
		//��ȡ��ɾ���б�����
		String poll = linkedList.poll();
		String pollFirst = linkedList.pollFirst();
		String pollLast = linkedList.pollLast();
		System.out.println("poll:"+poll+",pollFirst:"+pollFirst+",pollLast:"+pollLast);
		for (String string : linkedList) {
			System.out.println(string);
		}
		
		//�ӱ�ͷ���Ӻ�ɾ��
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
