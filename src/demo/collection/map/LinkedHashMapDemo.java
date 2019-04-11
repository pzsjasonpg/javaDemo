package demo.collection.map;

import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class LinkedHashMapDemo {
	
	/*
	 * LinkedHashMap���ص㣺
	 * 1. �̲߳���ȫ��
	 * 2. ��������˳������
	 * 3. ������null����nullֵ��
	 * 4. Ĭ����16�ĳ�ʼ��������������0.75��
	 */

	public static void main(String[] args) {
		
		LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();
		linkedHashMap.put("11", "java");
		linkedHashMap.put("2","php");
		linkedHashMap.put("3", "python");
		linkedHashMap.forEach(new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.println(t+":"+u);
				
			}
		});
		
		//������������������������HashMap��ͬ

	}

}
