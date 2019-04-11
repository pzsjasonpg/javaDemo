package demo.Thead.Thread;

public class ThreadDemo extends Thread {
	
	private String name;
	
	public ThreadDemo() {
		
	}
	
	public ThreadDemo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 5; i > 0; i --) {
			System.out.println("Thread: "+name+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

