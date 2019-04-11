package demo.collection.list;

import java.security.KeyStore.CallbackHandlerProtection;
import java.util.Vector;

import javax.lang.model.element.Element;


public class VectorDemo {
	
	/*
	 * Vector�ص㣺
	 * 1. ͬ���ģ�
	 * 2.��ѯ�ٶȿ죻
	 * 3.�����ٶ�����
	 * 4.��ʼ����Ϊ10��
	 * 5.Vector ������������������0ʱ�������鳤��Ϊԭ���鳤��+�����������������������鳤��Ϊԭ���鳤�ȵ�2��
	 */
	
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		
		
		System.out.println("----------���Ԫ��----------");
		for (int i = 0; i < 11; i ++) {
			vector.add("str"+i);
		}
		vector.addElement("Element");
		for (String string : vector) {
			System.out.println(string);
		}
		
		System.out.println("----------ɾ��Ԫ��----------");
		String remove = vector.remove(0);
		boolean remove2 = vector.remove("str1");
		boolean removeElement = vector.removeElement("str2");
		for (String string : vector) {
			System.out.println(string);
		}
		
		System.out.println("----------�޸�Ԫ��----------");
		String set = vector.set(0, "hello");
		vector.setElementAt("world", 1);
		vector.setSize(20);
		for (String string : vector) {
			System.out.println(string);
		}
		
		
		System.out.println("---------������Ϣ-----------");
		int capacity = vector.capacity();
		System.out.println(capacity);
		
		//clone��������޸�Դ������ô��¡����Ҳ��䣻�������ֻ�޸�clone����Դ�����򲻱䡣
//		vector.setElementAt("peng", 3);
		Vector<String> clone = (Vector<String>) vector.clone();
		clone.setElementAt("jaan", 4);
		for (String string : vector) {
			System.out.println(string);
		}
		
		
	}

}
