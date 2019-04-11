package demo.collection.map;

import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;

public class HashMapDemo {
	
	/*
	 * HashMap���ص㣺
	 * 1. �̲߳���ȫ��
	 * 2. Ԫ��û��˳��������ģ�
	 * 3. ������nullֵ���ڣ� ����ֻ����1��null�����ڣ�
	 * 4. Ĭ����16�ĳ�ʼ��������������0.75��
	 */

	public static void main(String[] args) {
		
		HashMap<String,String> hashMap = new HashMap<String,String>();
		
		System.out.println("----------���Ԫ��----------");
		hashMap.put("1", "java");
		hashMap.put("2", "php");
		hashMap.put("3", "python");
		
		Set<String> keySet = hashMap.keySet();
		for (String string : keySet) {
			System.out.println(string +":"+ hashMap.get(string));
		}
		
		System.out.println("----------ɾ��Ԫ��----------");
		String remove = hashMap.remove("1");
		for (String string : keySet) {
			System.out.println(string +":"+ hashMap.get(string));
		}
		
		System.out.println("----------�޸�Ԫ��----------");
		hashMap.replace("2", "php", "ruby");
		for (String string : keySet) {
			System.out.println(string +":"+ hashMap.get(string));
		}
		
		System.out.println("---------������Ϣ-----------");
		String string = hashMap.get("2");
		System.out.println(string);
		
		int size = hashMap.size();
		System.out.println(size);
		
		//��ӡ��ֵ��
		hashMap.forEach(new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				System.out.println(t+":"+u);
				
			}
		});

	}

}
