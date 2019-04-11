package demo.Thead.Runnable.Synchronized;

public class TestTickets {

	public static void main(String[] args) {
		SellTicket sellTicket = new SellTicket();
		Thread thread = new Thread(sellTicket, "窗口1");
		Thread thread1 = new Thread(sellTicket, "窗口2");
		Thread thread2 = new Thread(sellTicket, "窗口3");
		Thread thread3 = new Thread(sellTicket, "窗口4");
		Thread thread4 = new Thread(sellTicket, "窗口5");
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

}
