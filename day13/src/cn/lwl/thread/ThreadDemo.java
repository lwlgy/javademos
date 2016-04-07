package cn.lwl.thread;

public class ThreadDemo extends Thread {

	public ThreadDemo(String name) {
		super(name);
	}

	@Override
	public void run() {
//		try {
//			Thread.sleep(100); // ������쳣�����׳���ֻ�ܲ�����Ϊ����÷���û���׳��쳣
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		for (int i = 0; i < 100; i++) {
			System.out.println(this.getName() + ":" + i);
		}

		// System.out.println("this:" + this);
		// System.out.println("��ǰ�̶߳���:" + Thread.currentThread());
	}

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo("����");
		// td.setName("��ʣ");
		// td.sleep(1000); //��仰��������߳�˯�ߣ�sleep����ִ�и÷������߳�˯�ߣ��Ǿ�̬����
		td.setPriority(Thread.MAX_PRIORITY);// ���ȼ�����Χ��1-10��Խ�����ȼ�Խ�ߣ�Ĭ����5
		td.start();

		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}

		// Thread mainThread = Thread.currentThread();
		// System.out.println(mainThread.getName());
	}

}
