package cn.lwl.thread;
/*
 * join()方法：
 * 	
 * 
 * */

//老妈
class Mon extends Thread{
	@Override
	public void run() {
		System.out.println("妈妈洗菜");
		System.out.println("妈妈切菜");
		System.out.println("妈妈准备炒菜，发现没有酱油了...");
		// 叫儿子去打酱油
		Son s = new Son();
		s.start();
		try {
			s.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("妈妈继续炒菜");
		System.out.println("全家一起吃饭");
	}
}

class Son extends Thread{
	@Override
	public void run() {
		System.out.println("儿子下楼...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("儿子一直往前走");
		System.out.println("儿子打完酱油了");
		System.out.println("儿子上楼把酱油给老妈");
		
	}
}

public class ThreadJoin {

	public static void main(String[] args) {
		Mon m = new Mon();
		m.start();
		
	}

}
