package demo.Thead.Runnable.Synchronized;

public class TestTickets {

	public static void main(String[] args) {
		SellTicket sellTicket = new SellTicket();
		Thread thread = new Thread(sellTicket, "����1");
		Thread thread1 = new Thread(sellTicket, "����2");
		Thread thread2 = new Thread(sellTicket, "����3");
		Thread thread3 = new Thread(sellTicket, "����4");
		Thread thread4 = new Thread(sellTicket, "����5");
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

}
