package cn.lwl.thread;

/*
 模拟3个窗口售票，1辆客车可以卖50张票（假设只有1辆客车）
 
 注意点：
 	1.线程类中的票数对象要设置成静态（所有线程访问同一个票数对象）
 	2.线程安全问题（一个线程把票卖了，还没来得及--，另一个线程又卖了这张票）
 		解决方法，两种同步机制
 		1）同步代码块，注意事项：
 			a.锁对象可以是任意一个对象。
 			b.在同步代码块中调用sleep方法并不能释放锁对象
 			c.只有在存在线程安全问题的时候才使用同步代码块的时候才使用同步代码块，滥用会降低效率
 				判断是否存在线程安全问题的方法（出现线程安全问题的根本原因）：
 					存在两个或两个以上的线程对象，而且线程之间共享着一个资源。
 					有多个语句操作了共享资源
 			d.锁对象必须是唯一且共享的对象，否则无效
 			
 		2）同步函数
 			同步函数就是使用synchronized修饰一个函数:public synchronized void run()
 			a.如果是一个非静态的同步函数的锁，对象是this对象；如果是静态的同步函数，锁对象是当前函数所属类的字节码文件（class对象）
 			b.同步函数的锁对象是固定的，无法自己指定
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

	static Object lockObj = new Object();
	
	public SaleTicket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// 卖票
		while (true) {
			synchronized (lockObj) {				
//			synchronized ("锁") {	//这样也可以，这里的"锁"是字符串池中的，唯一的				
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + "售出了第"
							+ num + "号票");
					num--;
//					try {
//						Thread.sleep(1000); 
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				} else {
					System.out.println("卖完了!");
					break;
				}
			}
		}
	}
}