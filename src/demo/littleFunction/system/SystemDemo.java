package demo.littleFunction.system;

public class SystemDemo {

	public static void main(String[] args) {
		//��ȡϵͳ��������
		String getenv = System.getenv("JAVA_HOME");
		System.out.println(getenv);
		
		//��ȡ��ǰʱ���
		System.out.println(System.currentTimeMillis());

		
	}

}
