package demo.collection.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
	
	/*
	 * LinkedHashSet�ص㣺
	 * 1. ���ղ���˳������
	 * 2. �̲߳���ȫ
	 * 3. Ԫ�ز��ظ���
	 * 4. �������null������ֻ����һ��
	 */
	
	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		
		//��֤����˳�� and �ظ���
		linkedHashSet.add("link");
		linkedHashSet.add("hello");
		linkedHashSet.add("nihao");
		linkedHashSet.add("nihao");
		linkedHashSet.add(null);
		linkedHashSet.add(null);
		
		for (String string : linkedHashSet) {
			System.out.println(string);
		}
		
		//����������HashSetһ��
		

		
	}

}
