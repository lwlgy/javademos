package cn.lwl.thread;

public class ThreadDemo extends Thread {

	public ThreadDemo(String name) {
		super(name);
	}

	@Override
	public void run() {
//		try {
//			Thread.sleep(100); // 这里的异常不能抛出，只能捕获，因为父类该方法没有抛出异常
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + ":" + i);
		}

		// System.out.println("this:" + this);
		// System.out.println("当前线程对象:" + Thread.currentThread());
	}

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo("狗娃");
		// td.setName("狗剩");
		// td.sleep(1000); //这句话会造成主线程睡眠，sleep是让执行该方法的线程睡眠，是静态方法
		td.setPriority(Thread.MAX_PRIORITY);// 优先级，范围是1-10，越大优先级越高，默认是5
		td.start();

		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}

		// Thread mainThread = Thread.currentThread();
		// System.out.println(mainThread.getName());
	}

}
