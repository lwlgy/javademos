package cn.lwl.thread;

/*
 * 线程通信：一个线程完成之后通知另一个线程
 * 
 * 生产者与消费者
 * 
 * wait():等待
 * notify():唤醒
 * 注意事项：
 * 		1.这两个方法是属于Object类的
 * 		2.这两个方法必须要在同步代码块或同步函数中使用（必须要有同步才能用）
 * 		3.这两个方法必须要由锁对象调用
 * 
 * 
 */
public class ThreadCommunication {

	public static void main(String[] args) {
		Product p = new Product();
		// 创建生产者对象
		Producer producer = new Producer("张三", p);
		// 创建消费者
		Customer customer = new Customer("李四", p);

		producer.start();
		customer.start();
	}
}

// 产品类
class Product {
	String name; // 名称
	double price; // 价格
	boolean flag = false;// 是否生产完成的标识，默认情况是没有生产完成的
}

// 生产者
class Producer extends Thread {

	// 产品
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
						p.name = "苹果";
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						p.price = 6.5;
					} else {
						p.name = "香蕉";
						p.price = 2;
					}
					System.out
							.println("生产者生产了:" + p.name + "   价格是:" + p.price);
					p.flag = true;
					i++;
					p.notify();
				} else {
					// 已经生产完毕，等待消费者消费
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

// 消费者
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
							.println("消费者消费了:" + p.name + "   价格是:" + p.price);
					p.flag = false;
					p.notify();
				} else {
					// 产品还没有生产，等待生产者生产
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