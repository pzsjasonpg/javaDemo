package demo.littleFunction.string;

public class StringBufferDemo {
	
	/*
	 * StringBuffer���ص㣺
	 * 1. �̰߳�ȫ
	 * 2. ��ʼ������16
	 */

	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer();
		
		//���
		sBuffer.append("hello,");
		sBuffer.append("world");
		System.out.println(sBuffer);

		//ɾ��
		//6��λ�ò�ɾ��
		sBuffer.delete(6, 10);
		System.out.println(sBuffer);
		
		//����
		sBuffer.insert(0, "peng");
		System.out.println(sBuffer);
		
		//��
		sBuffer.replace(0, 4, "jasonpg");
		System.out.println(sBuffer);
	}

}
