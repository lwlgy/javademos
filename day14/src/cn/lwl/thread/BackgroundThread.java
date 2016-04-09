package cn.lwl.thread;

/*
 * 守护线程（后台线程）:在一个进程中如果只剩下守护线程，那么守护线程也会死亡。
 * 
 * 模拟软件升级
 * 
 * 
 * */
public class BackgroundThread extends Thread {

	public BackgroundThread(String name) {
		super(name);
	}

	public static void main(String[] args) {
		BackgroundThread bt = new BackgroundThread("后台线程");
		bt.setDaemon(true);
//		System.out.println("是守护线程吗？" + bt.isDaemon());
//		bt.setPriority(Thread.MAX_PRIORITY);
		bt.start();

		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("更新包目前下载到" + i + "%");
			if (i == 100) {
				System.out.println("更新包下载完成，准备安装！");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
