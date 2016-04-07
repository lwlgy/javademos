package cn.lwl.thread;

public class Bank {

	public static void main(String[] args) {
		BankThread manThread = new BankThread("�ɷ�");
		BankThread womanThread = new BankThread("����");
		manThread.start();
		womanThread.start();
	}

}

class BankThread extends Thread {

	static int money = 5000;

	static Object lockObj = new Object();

	public BankThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		//��һ�ַ�ʽ��ͬ�������
//		while (true) {
//			synchronized (lockObj) {
//				if (money > 0) {
//					System.out.println(Thread.currentThread().getName()
//							+ "ȡ��1000��Ǯ��ʣ��" + (money - 1000) + "��Ǯ");
//					money -= 1000;
//				} else {
//					System.out.println("Ǯȡ���ˣ�");
//					break;
//				}
//			}
//		}
		
		//�ڶ��ַ�ʽ��ͬ������
		withdraw();
	}

	public static synchronized void withdraw() {
		while (true) {
			if (money > 0) {
				System.out.println(Thread.currentThread().getName()
						+ "ȡ��1000��Ǯ��ʣ��" + (money - 1000) + "��Ǯ");
				money -= 1000;
			} else {
				System.out.println("Ǯȡ���ˣ�");
				break;
			}
		}
	}
}