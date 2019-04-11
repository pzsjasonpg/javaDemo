package demo.Thead.Thread.Synchronized;

class A{
	
}

public class SellTicket extends Thread {

	private String name;
	private static int tickets = 100;
	
	//锁对象
	private static Object o1 = new Object();
	private static A a = new A();
	
	public SellTicket() {
		
	}

	public SellTicket(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		while(true) {
			/*
			 * 当继承Thread时，锁对象也必须是共享对象，这样才能开锁，解锁
			 */
			synchronized (o1) {
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name + "正在卖票，还剩"+tickets--);
				} else {
					System.out.println("票已经卖完！");
					break;
				}
			}
		}
	}
	
}
