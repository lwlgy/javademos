package cn.lwl.thread;

/*
 ģ��3��������Ʊ��1���ͳ�������50��Ʊ������ֻ��1���ͳ���
 
 ע��㣺
 	1.�߳����е�Ʊ������Ҫ���óɾ�̬�������̷߳���ͬһ��Ʊ������
 	2.
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

	public SaleTicket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// ��Ʊ
		while (true) {
			if (num > 0) {
				System.out.println(Thread.currentThread().getName() + "�۳��˵�"
						+ num + "��Ʊ");
				num--;
			} else {
				System.out.println("������!");
				break;
			}

		}
	}
}