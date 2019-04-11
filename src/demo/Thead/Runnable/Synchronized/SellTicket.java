package demo.Thead.Runnable.Synchronized;

class A{
	
}

public class SellTicket implements Runnable {

	private String name;
	/*
	 * ʵ��Runnableʵ�ֶ��̣߳�����������Բ�Ϊ��̬
	 * ��ΪRunnableֻ��run���������������̵߳ķ�����ʵ��Runable����Thread�ϣ�
	 * ����Ҫʹ�ö�̬����Runable���󴫸�Thread���췽��
	 * ��ΪRunable����ֻ��һ�������Թ�������Ϳ��Բ�Ϊ��̬��
	 * ͬʱ������Ҳ���Բ�Ϊstatic�������Բ�Ϊ�����
	 */
	private int tickets = 100;
	
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
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					System.out.println(Thread.currentThread().getName() + "������Ʊ����ʣ"+tickets--);
				} else {
					System.out.println("Ʊ�Ѿ����꣡");
					break;
				}
			}
		}
	}
	
}
