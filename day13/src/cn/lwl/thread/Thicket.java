package cn.lwl.thread;

/*
 ģ��3��������Ʊ��1���ͳ�������50��Ʊ������ֻ��1���ͳ���
 
 ע��㣺
 	1.�߳����е�Ʊ������Ҫ���óɾ�̬�������̷߳���ͬһ��Ʊ������
 	2.�̰߳�ȫ���⣨һ���̰߳�Ʊ���ˣ���û���ü�--����һ���߳�����������Ʊ��
 		�������������ͬ������
 		1��ͬ������飬ע�����
 			a.���������������һ������
 			b.��ͬ��������е���sleep�����������ͷ�������
 			c.ֻ���ڴ����̰߳�ȫ�����ʱ���ʹ��ͬ��������ʱ���ʹ��ͬ������飬���ûή��Ч��
 				�ж��Ƿ�����̰߳�ȫ����ķ����������̰߳�ȫ����ĸ���ԭ�򣩣�
 					�����������������ϵ��̶߳��󣬶����߳�֮�乲����һ����Դ��
 					�ж���������˹�����Դ
 			d.�����������Ψһ�ҹ���Ķ��󣬷�����Ч
 			
 		2��ͬ������
 			ͬ����������ʹ��synchronized����һ������:public synchronized void run()
 			a.�����һ���Ǿ�̬��ͬ������������������this��������Ǿ�̬��ͬ���������������ǵ�ǰ������������ֽ����ļ���class����
 			b.ͬ���������������ǹ̶��ģ��޷��Լ�ָ��
 */
public class Thicket {

	
	public static void main(String[] args) {
		SaleTicket[] sts = new SaleTicket[3];
		for (int i = 0; i < sts.length; i++) {
			sts[i] = new SaleTicket("����" + i);
		}
		for (int i = 0; i < sts.length; i++) {
			sts[i].start();
		}
	}
}

class SaleTicket extends Thread {
	static int num = 50;// Ʊ�����Ǿ�̬�ĳ�Ա����������ÿ���������涼��洢һ�ݣ��˴���Ҫ����Ϊ��̬�������������ڹ���ͬһ������

	static Object lockObj = new Object();
	
	public SaleTicket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// ��Ʊ
		while (true) {
			synchronized (lockObj) {				
//			synchronized ("��") {	//����Ҳ���ԣ������"��"���ַ������еģ�Ψһ��				
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + "�۳��˵�"
							+ num + "��Ʊ");
					num--;
//					try {
//						Thread.sleep(1000); 
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				} else {
					System.out.println("������!");
					break;
				}
			}
		}
	}
}