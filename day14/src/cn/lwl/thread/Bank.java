package cn.lwl.thread;

public class Bank {

	public static void main(String[] args) {
		BankThread manThread = new BankThread("丈夫");
		BankThread womanThread = new BankThread("妻子");
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
		//第一种方式，同步代码块
//		while (true) {
//			synchronized (lockObj) {
//				if (money > 0) {
//					System.out.println(Thread.currentThread().getName()
//							+ "取了1000块钱，剩余" + (money - 1000) + "块钱");
//					money -= 1000;
//				} else {
//					System.out.println("钱取完了！");
//					break;
//				}
//			}
//		}
		
		//第二种方式，同步函数
		withdraw();
	}

	public static synchronized void withdraw() {
		while (true) {
			if (money > 0) {
				System.out.println(Thread.currentThread().getName()
						+ "取了1000块钱，剩余" + (money - 1000) + "块钱");
				money -= 1000;
			} else {
				System.out.println("钱取完了！");
				break;
			}
		}
	}
}