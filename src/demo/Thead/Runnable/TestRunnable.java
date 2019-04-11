package demo.Thead.Runnable;

class TestRunnable {

	public static void main(String[] args) {
		RunnableDemo runnableDemo = new RunnableDemo("thread1");
		runnableDemo.start();
		
		RunnableDemo runnableDemo2 = new RunnableDemo("thread2");
		runnableDemo2.start();

	}
}
