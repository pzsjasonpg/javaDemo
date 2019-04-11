package demo.collection.map;

import java.util.Hashtable;
import java.util.function.BiConsumer;

public class HashTableDemo {
	
	/*
	 * HashTable���ص㣺
	 * 1. �̰߳�ȫ��
	 * 2. �������κε�null����nullֵ��
	 * 3. ����
	 * 4. Ĭ����11�ĳ�ʼ��������������0.75��
	 */

	public static void main(String[] args) {
		
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("1", "java");
		hashtable.put("2", "python");
		hashtable.put("3", "php");
		hashtable.forEach(new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.println(t+":"+u);
				
			}
		});
		
		

	}

}
