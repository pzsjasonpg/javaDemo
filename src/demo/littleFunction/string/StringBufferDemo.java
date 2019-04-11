package demo.littleFunction.string;

public class StringBufferDemo {
	
	/*
	 * StringBuffer的特点：
	 * 1. 线程安全
	 * 2. 初始容量是16
	 */

	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer();
		
		//添加
		sBuffer.append("hello,");
		sBuffer.append("world");
		System.out.println(sBuffer);

		//删除
		//6的位置不删除
		sBuffer.delete(6, 10);
		System.out.println(sBuffer);
		
		//插入
		sBuffer.insert(0, "peng");
		System.out.println(sBuffer);
		
		//改
		sBuffer.replace(0, 4, "jasonpg");
		System.out.println(sBuffer);
	}

}
