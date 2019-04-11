package demo.collection.set;

import java.util.TreeSet;

import demo.collection.set.comparator.MyComparator;

public class TreeSetDemo {
	
	/*
	 * TreeSet�ص㣺
	 * 1. �̲߳���ȫ
	 * 2. ���򼯺ϣ���Ԫ����Ȼ����
	 * 
	 */
	
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		System.out.println("----------���Ԫ��----------");
		//����֤����
		treeSet.add(100);
		treeSet.add(23);
		treeSet.add(33);
		treeSet.add(11);
		treeSet.add(15);
		for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		
		System.out.println("----------ɾ��Ԫ��----------");
		treeSet.remove(15);
		//���ز�ɾ����Ԫ��
		Integer pollFirst = treeSet.pollFirst();
		Integer pollLast = treeSet.pollLast();
		for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		
		System.out.println("----------�ȸ�Ԫ�ش��С��Ԫ��----------");
		//���ش� set ���ϸ���ڸ���Ԫ�ص���СԪ�أ����������������Ԫ�أ��򷵻� null��
		Integer higher = treeSet.higher(15);
		System.out.println(higher);
		//���ش� set ���ϸ�С�ڸ���Ԫ�ص����Ԫ�أ����������������Ԫ�أ��򷵻� null��
		Integer lower = treeSet.lower(23);
		System.out.println(lower);
		//���ش� set ��С�ڵ��ڸ���Ԫ�ص����Ԫ�أ����������������Ԫ�أ��򷵻� null��
		Integer floor = treeSet.floor(23);
		System.out.println(floor);
		
		//��֤����
		System.out.println("-------------��֤����-----------------");
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
