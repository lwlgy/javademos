package cn.lwl.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/*
 ��ҵ2��ʹ�ü���ʵ��ע���½���ܣ�

 ��һ���� ��ʾ�û�ѡ���ܣ� A��ע�ᣩ  B(��½) �� Ҫ�� ����ѡ�� ��ʱ��Ҫ���Դ�Сд��


 ע�᣺
 1. ��ʾ�û�����ע����˺�(����)�����룬��������id���Ѿ����ڼ����У���ʾ�û��������롣 ע�����֮�󣬰Ѽ����е������û���Ϣ��ӡ������(ʹ�ã�toArrry()����)	

 ��½�� 
 ��ʾ�û������½���˺�������,����˺�����������û��Ѿ����ڼ����У���ô��½�ɹ��������½ʧ�ܡ�
 */
public class HomeWork {
	static Scanner scanner = new Scanner(System.in);
	static Collection users = new ArrayList<People>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("��ѡ��Ҫ���еĲ��� : A��ע�ᣩ  B(��½)");
			String s = scanner.next();
			if (s.equalsIgnoreCase("a")) {
				reg();

			} else if (s.equalsIgnoreCase("b")) {
				login();
			}
		}
	}

	private static void login() {
		// ��¼
		System.out.println("�������˺�:");
		int id = scanner.nextInt();
		System.out.println("����������:");
		String password = scanner.next();
		
		Iterator it = users.iterator();
		boolean isLogin = false;
		while(it.hasNext()){
			People p = (People)it.next();
			if(p.getId() == id && p.getPassword().equals(password)){
				isLogin = true;
				break;
			}
		}
		if(isLogin){
			System.out.println("��¼�ɹ�!");
		}
		else{
			System.out.println("�û������������!");
		}
	}

	private static void reg() {
		String s;
		// ע��
		int id = 0;
		People p = new People(0,null);
		inner: while (true) {
			System.out.print("������ע����˺�:");
			s = scanner.next();
			id = Integer.parseInt(s);
			p.setId(id);
			if (!users.contains(p)) {
				break inner;
			}
			System.out.println("���˺��Ѵ���!");
		}
		System.out.print("����������:");
		s = scanner.next();
		p.setPassword(s);
		users.add(p);
		System.out.println(users);
	}
}

class People {
	int id;
	String password;

	public People(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "{���=" + id + ", ����=" + password + "}";
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		People p = (People) obj;
		return this.id == p.id;
	}

}