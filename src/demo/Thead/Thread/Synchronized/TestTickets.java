package demo.Thead.Thread.Synchronized;

public class TestTickets {

	public static void main(String[] args) {
		SellTicket thread = new SellTicket("����1");
		SellTicket thread1 = new SellTicket("����2");
		SellTicket thread2 = new SellTicket("����3");
		SellTicket thread3 = new SellTicket("����4");
		SellTicket thread4 = new SellTicket("����5");
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

}
