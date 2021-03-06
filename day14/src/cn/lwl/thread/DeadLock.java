package cn.lwl.thread;
/*
 	死锁现象
		“哲学家就餐问题”
		
	死锁发生的根本原因：（互相等待资源）
		1.存在两个或两个以上的线程
		2.存在两个或两个以上的共享资源
		
	死锁现象的解决方案：
		没有解决方案，只能尽量避免发生。

*/
public class DeadLock {

	public static void main(String[] args) {
		DeadLockThread thread1 = new DeadLockThread("张三");
		DeadLockThread thread2 = new DeadLockThread("狗娃");
		thread1.start();
		thread2.start();
	}
}

class DeadLockThread extends Thread{
	public DeadLockThread(String name){
		super(name);
	}
	@Override
	public void run() {
		if("张三".equals(Thread.currentThread().getName())){
			synchronized ("遥控器") {
				System.out.println("张三拿到了遥控器，准备去拿电池");
				synchronized ("电池") {
					System.out.println("张三拿到了遥控器和电池，可以开空调");
				}
			}
		}else if("狗娃".equals(Thread.currentThread().getName())){
			synchronized("电池"){
				System.out.println("李四拿到了电池，准备去拿遥控器");
				synchronized ("遥控器") {
					System.out.println("李四拿到了电池和遥控器，可以开空调");
				}
			}
		}
	}
}