package com.lwl.object;

/*
 * java是面向对象的语言，核心思想是找适合的对象做适合的事情
 * 
 * 方式一：自定义类，然后通过自定义的类创建对象
 * 
 * 方式二：sun提供了很多类供我们使用，我们只要认识这些类，就可以通过这些类来创建对象
 * 
 * 所有对象都继承了Object类
 * 
 * 	Object类常用的方法：
 * 		toString()				返回该对象的字符串表示
 * 		equals(Object obj)		
 * 		hashCode()
 * 
 * 
 * 查看源代码的方式：
 * 		方式一：按住ctrl键，单击需要看的源代码
 * 		方式二：把光标移动到需要查看的代码处按f3
 * */

public class Demo1 {
	public static void main(String[] args) {
//		Object o = new Object();
//		System.out.println(o.toString());
//		System.out.println(o);
		Person p1 = new Person(110,"狗剩");
		Person p2 = new Person(110,"陈大幅");
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}