package demo.littleFunction.string;

public class StringBuilderDemo {
	
	/*
	 * StringBuilder的特点：
	 * 1. 线程不安全
	 * 2. 初始容量是16
	 */

	public static void main(String[] args) {
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("java,");
		sBuilder.append("python");
		System.out.println(sBuilder);
		
		//初始容量是16
		int capacity = sBuilder.capacity();
		System.out.println(capacity);
		
		//翻转
		System.out.println(sBuilder.reverse());
		

	}

}
