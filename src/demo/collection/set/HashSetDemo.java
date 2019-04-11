package demo.collection.set;

import java.util.HashSet;

public class HashSetDemo {
	
	/*
	 * HashSet�ص㣺
	 * 1. ������
	 * 2. ���ظ���
	 * 3. ������String���͵Ŀ��Բ���null
	 * 4. �̲߳���ȫ
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
		
		//��֤����null
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("hello");
		hashSet1.add("world");
		hashSet1.add("nihao");
		hashSet1.add(null);
		hashSet1.add(null);
		
		for (String integer : hashSet1) {
			System.out.println(integer);
		}
		
		System.out.println("----------���Ԫ��----------");
		hashSet1.add("peng");
		for (String integer : hashSet1) {
			System.out.println(integer);
		}
		
		System.out.println("----------ɾ��Ԫ��----------");
		hashSet1.remove("nihao");
		for (String integer : hashSet1) {
			System.out.println(integer);
		}
		
		
		
	}

}
