package demo.Thead.Thread.Synchronized;

class A{
	
}

public class SellTicket extends Thread {

	private String name;
	private static int tickets = 100;
	
	//������
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
			 * ���̳�Threadʱ��������Ҳ�����ǹ�������������ܿ���������
			 */
			synchronized (o1) {
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name + "������Ʊ����ʣ"+tickets--);
				} else {
					System.out.println("Ʊ�Ѿ����꣡");
					break;
				}
			}
		}
	}
	
}
