package demo.Thead.Runnable.Synchronized;

class A{
	
}

public class SellTicket implements Runnable {

	private String name;
	/*
	 * 实现Runnable实现多线程，共享变量可以不为静态
	 * 因为Runnable只有run方法，而启动多线程的方法在实现Runable的类Thread上，
	 * 所以要使用多态，将Runable对象传给Thread构造方法
	 * 因为Runable对象只有一个，所以共享变量就可以不为静态的
	 * 同时锁对象也可以不为static，即可以不为共享的
	 */
	private int tickets = 100;
	
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
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + "正在卖票，还剩"+tickets--);
				} else {
					System.out.println("票已经卖完！");
					break;
				}
			}
		}
	}
	
}
