package cn.lwl.thread;

/*
 * �ػ��̣߳���̨�̣߳�:��һ�����������ֻʣ���ػ��̣߳���ô�ػ��߳�Ҳ��������
 * 
 * ģ���������
 * 
 * 
 * */
public class BackgroundThread extends Thread {

	public BackgroundThread(String name) {
		super(name);
	}

	public static void main(String[] args) {
		BackgroundThread bt = new BackgroundThread("��̨�߳�");
		bt.setDaemon(true);
//		System.out.println("���ػ��߳���" + bt.isDaemon());
//		bt.setPriority(Thread.MAX_PRIORITY);
		bt.start();

		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("���°�Ŀǰ���ص�" + i + "%");
			if (i == 100) {
				System.out.println("���°�������ɣ�׼����װ��");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
