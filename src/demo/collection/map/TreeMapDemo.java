package demo.collection.map;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapDemo {
	
	/*
	 * TreeMap���ص㣺
	 * 1. �̲߳���ȫ��
	 * 2. �����ظ���
	 * 3. ��������null��ֵ����Ϊnull��
	 * 4. ���������
	 */

	public static void main(String[] args) {
		TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "python");
		treeMap.put(100, "java");
		treeMap.put(4, "php");
		treeMap.put(5, null);
		treeMap.put(33, null);
		//������ͬ�ļ�������ĻḲ�������ֵ
		treeMap.put(100, "ruby");
		
		treeMap.forEach(new BiConsumer<Integer, String>() {

			@Override
			public void accept(Integer t, String u) {
				System.out.println(t.toString() +":"+u);
				
			}
		});

	}

}
