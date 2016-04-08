package cn.lwl.thread;

/*
 * �߳�ͨ�ţ�һ���߳����֮��֪ͨ��һ���߳�
 * 
 * ��������������
 * 
 * wait():�ȴ�
 * notify():����
 * ע�����
 * 		1.����������������Object���
 * 		2.��������������Ҫ��ͬ��������ͬ��������ʹ�ã�����Ҫ��ͬ�������ã�
 * 		3.��������������Ҫ�����������
 * 
 * 
 */
public class ThreadCommunication {

	public static void main(String[] args) {
		Product p = new Product();
		// ���������߶���
		Producer producer = new Producer("����", p);
		// ����������
		Customer customer = new Customer("����", p);

		producer.start();
		customer.start();
	}
}

// ��Ʒ��
class Product {
	String name; // ����
	double price; // �۸�
	boolean flag = false;// �Ƿ�������ɵı�ʶ��Ĭ�������û��������ɵ�
}

// ������
class Producer extends Thread {

	// ��Ʒ
	Product p;

	public Producer(String name, Product p) {
		super(name);
		this.p = p;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (p) {
				if (p.flag == false) {
					if (i % 2 == 0) {
						p.name = "ƻ��";
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						p.price = 6.5;
					} else {
						p.name = "�㽶";
						p.price = 2;
					}
					System.out
							.println("������������:" + p.name + "   �۸���:" + p.price);
					p.flag = true;
					i++;
					p.notify();
				} else {
					// �Ѿ�������ϣ��ȴ�����������
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

// ������
class Customer extends Thread {
	Product p;

	public Customer(String name, Product p) {
		super(name);
		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (p) {
				if (p.flag) {
					System.out
							.println("������������:" + p.name + "   �۸���:" + p.price);
					p.flag = false;
					p.notify();
				} else {
					// ��Ʒ��û���������ȴ�����������
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}