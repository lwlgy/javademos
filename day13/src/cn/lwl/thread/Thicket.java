package cn.lwl.thread;

/*
 模拟3个窗口售票，1辆客车可以卖50张票（假设只有1辆客车）
 
 注意点：
 	1.线程类中的票数对象要设置成静态（所有线程访问同一个票数对象）
 	2.
 */
public class Thicket {

	public static void main(String[] args) {
		SaleTicket[] sts = new SaleTicket[3];
		for (int i = 0; i < sts.length; i++) {
			sts[i] = new SaleTicket("窗口" + i);
		}
		for (int i = 0; i < sts.length; i++) {
			sts[i].start();
		}
	}
}

class SaleTicket extends Thread {
	static int num = 50;// 票数，非静态的成员变量数据在每个对象里面都会存储一份，此处需要设置为静态变量，三个窗口共享同一个对象

	public SaleTicket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// 卖票
		while (true) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + "售出了第"
						+ num + "号票");
				num--;
			} else {
				System.out.println("卖完了!");
				break;
			}

		}
	}
}