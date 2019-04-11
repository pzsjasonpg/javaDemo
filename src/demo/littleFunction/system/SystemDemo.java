package demo.littleFunction.system;

public class SystemDemo {

	public static void main(String[] args) {
		//获取系统环境变量
		String getenv = System.getenv("JAVA_HOME");
		System.out.println(getenv);
		
		//获取当前时间戳
		System.out.println(System.currentTimeMillis());

		
	}

}
