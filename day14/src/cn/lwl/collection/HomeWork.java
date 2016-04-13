package cn.lwl.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/*
 作业2：使用集合实现注册登陆功能，

 第一步： 提示用户选择功能， A（注册）  B(登陆) 。 要求： 功能选择 的时候要忽略大小写。


 注册：
 1. 提示用户输入注册的账号(数字)与密码，如果输入的id号已经存在集合中，提示用户重新输入。 注册完毕之后，把集合中的所有用户信息打印出来。(使用：toArrry()方法)	

 登陆： 
 提示用户输入登陆的账号与密码,如果账号与密码这个用户已经存在集合中，那么登陆成功，否则登陆失败。
 */
public class HomeWork {
	static Scanner scanner = new Scanner(System.in);
	static Collection users = new ArrayList<People>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("请选择要进行的操作 : A（注册）  B(登陆)");
			String s = scanner.next();
			if (s.equalsIgnoreCase("a")) {
				reg();

			} else if (s.equalsIgnoreCase("b")) {
				login();
			}
		}
	}

	private static void login() {
		// 登录
		System.out.println("请输入账号:");
		int id = scanner.nextInt();
		System.out.println("请输入密码:");
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
			System.out.println("登录成功!");
		}
		else{
			System.out.println("用户名或密码错误!");
		}
	}

	private static void reg() {
		String s;
		// 注册
		int id = 0;
		People p = new People(0,null);
		inner: while (true) {
			System.out.print("请输入注册的账号:");
			s = scanner.next();
			id = Integer.parseInt(s);
			p.setId(id);
			if (!users.contains(p)) {
				break inner;
			}
			System.out.println("该账号已存在!");
		}
		System.out.print("请输入密码:");
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
		return "{编号=" + id + ", 密码=" + password + "}";
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