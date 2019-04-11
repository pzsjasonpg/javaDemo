package demo.littleFunction.string;

public class StringBuilderDemo {
	
	/*
	 * StringBuilder���ص㣺
	 * 1. �̲߳���ȫ
	 * 2. ��ʼ������16
	 */

	public static void main(String[] args) {
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("java,");
		sBuilder.append("python");
		System.out.println(sBuilder);
		
		//��ʼ������16
		int capacity = sBuilder.capacity();
		System.out.println(capacity);
		
		//��ת
		System.out.println(sBuilder.reverse());
		

	}

}
