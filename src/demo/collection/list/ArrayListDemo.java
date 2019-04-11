package demo.collection.list;

import java.util.ArrayList;
import java.util.Comparator;

import javax.sound.midi.Soundbank;

public class ArrayListDemo {

	/*
	 * java.util.ArrayList�ص㣺
	 * 1.�����̰߳�ȫ�ģ�
	 * 2.��ѯ�ٶȿ죻
	 * 3.�����ٶ�����
	 * 4.��ʼ����Ϊ10��
	 * 5.ArrayList��1.5���ķ�ʽ������
	 * 
	 */
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<String> arrayListForTest = new ArrayList<String>();
		
		System.out.println("----------���Ԫ��----------");
		//���Ԫ��
		arrayList.add("hello");
		arrayList.add(1, "world");
		arrayListForTest.add("hi");
		arrayListForTest.add("jason");
		arrayList.addAll(arrayListForTest);
		for (String str : arrayList) {
			System.out.println(str);
		}
		
		System.out.println("----------ɾ��Ԫ��----------");
		
		//ɾ��Ԫ��
		arrayList.remove(1);
		arrayList.removeAll(arrayListForTest);
		for (String str : arrayList) {
			System.out.println(str);
		}
		
		System.out.println("----------�޸�Ԫ��----------");
		
		//�޸�Ԫ��
		arrayList.set(0, "java");
		for (String str : arrayList) {
			System.out.println(str);
		}
		
		System.out.println("---------������Ϣ-----------");
		
		//������Ϣ
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		for(int i=10;i>0;i--) {
			arrayList2.add(i);
		}
		int indexOf = arrayList2.indexOf(10);
		boolean contains = arrayList2.contains(1);
		Integer integer = arrayList2.get(1);
		System.out.println(indexOf);
		System.out.println(contains);
		System.out.println(integer);
		
		//����
		arrayList2.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		for (Integer integer1 : arrayList2) {
			System.out.println(integer1);
		}
		
	}

}
