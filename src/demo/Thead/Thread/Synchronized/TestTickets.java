package demo.Thead.Thread.Synchronized;

public class TestTickets {

	public static void main(String[] args) {
		SellTicket thread = new SellTicket("窗口1");
		SellTicket thread1 = new SellTicket("窗口2");
		SellTicket thread2 = new SellTicket("窗口3");
		SellTicket thread3 = new SellTicket("窗口4");
		SellTicket thread4 = new SellTicket("窗口5");
		
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}

}
