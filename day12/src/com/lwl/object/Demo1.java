package com.lwl.object;

/*
 * java�������������ԣ�����˼�������ʺϵĶ������ʺϵ�����
 * 
 * ��ʽһ���Զ����࣬Ȼ��ͨ���Զ�����ഴ������
 * 
 * ��ʽ����sun�ṩ�˺ܶ��๩����ʹ�ã�����ֻҪ��ʶ��Щ�࣬�Ϳ���ͨ����Щ������������
 * 
 * ���ж��󶼼̳���Object��
 * 
 * 	Object�ೣ�õķ�����
 * 		toString()				���ظö�����ַ�����ʾ
 * 		equals(Object obj)		
 * 		hashCode()
 * 
 * 
 * �鿴Դ����ķ�ʽ��
 * 		��ʽһ����סctrl����������Ҫ����Դ����
 * 		��ʽ�����ѹ���ƶ�����Ҫ�鿴�Ĵ��봦��f3
 * */

public class Demo1 {
	public static void main(String[] args) {
//		Object o = new Object();
//		System.out.println(o.toString());
//		System.out.println(o);
		Person p1 = new Person(110,"��ʣ");
		Person p2 = new Person(110,"�´��");
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}