package cn.lwl.thread;
/*
 	��������
		����ѧ�ҾͲ����⡱
		
*/
public class DeadLock {

	public static void main(String[] args) {
		DeadLockThread thread1 = new DeadLockThread("����");
		DeadLockThread thread2 = new DeadLockThread("����");
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
		if("����".equals(Thread.currentThread().getName())){
			synchronized ("ң����") {
				System.out.println("�����õ���ң������׼��ȥ�õ��");
				synchronized ("���") {
					System.out.println("�����õ���ң�����͵�أ����Կ��յ�");
				}
			}
		}else if("����".equals(Thread.currentThread().getName())){
			synchronized("���"){
				System.out.println("�����õ��˵�أ�׼��ȥ��ң����");
				synchronized ("ң����") {
					System.out.println("�����õ��˵�غ�ң���������Կ��յ�");
				}
			}
		}
	}
}