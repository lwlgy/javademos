package cn.lwl.thread;

public class CreateThread {

	public static void main(String[] args) {
		Runnable r = new MyThread();
		Thread t = new Thread(r, "¹·ÍÞ");
		t.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}