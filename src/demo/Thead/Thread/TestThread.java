package demo.Thead.Thread;

public class TestThread{
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadDemo("p1"), "thread1");
		thread.start();
		
		Thread thread2 = new Thread(new ThreadDemo("p2"), "thread2");
		thread2.start();
	}
}
