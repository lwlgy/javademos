package cn.lwl.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合：集合是存储对象数据的集合容器。
 * 
 * 集合相对数组的优势：
 * 		1.集合可以存储任意类型的对象数据，数组只能存储同一种数据类型的数据。
 * 		2.集合的长度是可变的，数组的长度是固定的。
 * 
 * ------------| Collection	单例集合的根接口
 * -----------------| List	如果是实现了List接口的集合类，具备的特点是：有序，可重复
 * -----------------| Set	如果是实现了Set接口的集合类，具备的特点是：无序，不可重复
 * 
 * Collection中的方法：
 * 		增加：
 * 			add(E e)								添加成功返回true，添加失败返回false
 * 			addAll(Collection<Object> c) 			把一个集合中的元素添加到另一个集合中
 * 		删除：
 * 			clear() 
 * 			remove(Object o) 
 * 			removeAll(Collection<?> c) 
 * 			retainAll(Collection<?> c) 
 * 		查看：
 *			size()
 * 		判断：
 * 			contains(Object o) 
 * 			containsAll(Collection<?> c)
 *			isEmpty()
 * 		迭代：
 *			toArray()			 
 * 			iterator() 

 */
public class Demo1 {
	public static void main(String[] args) {
		/*
		 * Collection c = new ArrayList(); // c.add("abc"); // c.add(1); //
		 * c.add(3.14); c.add("令计划"); c.add("徐才厚"); c.add("周永康"); //
		 * System.out.println("添加成功吗?"+c.add("郭美美"));
		 */
		/*
		 * Collection c2 = new ArrayList(); c2.add("刘德华"); c2.add("张学友");
		 * c2.add("郭富城"); c2.add("黎明");
		 * 
		 * c.addAll(c2); // 把c2中的元素添加到c中
		 */
		// c.clear();// 清空集合中的元素

		// System.out.println("删除成功吗?"+c.remove("计划"));
		// System.out.println("删除成功吗?"+c.remove("令计划"));

		/*
		 * Collection c2 = new ArrayList(); c2.add("令计划"); c2.add("徐才厚");
		 * c2.add("郭富城"); c2.add("黎明"); c.removeAll(c2);// 删除c中与c2的交集元素
		 */

		/*
		 * Collection c2 = new ArrayList(); c2.add("令计划"); c2.add("徐才厚");
		 * c2.add("郭富城"); c2.add("黎明"); c.retainAll(c2);// 保留c中与c2的交集元素，删除其余元素
		 */
		/*
		 * c.clear(); System.out.println("数组的元素个数是:"+c.size());
		 */

		/*
		 * // c.clear(); System.out.println("集合是否为空元素?" + c.isEmpty());
		 */

		// System.out.println("数组中是否存在相应的元素?"+c.contains("徐才厚"));

		// 添加自定义元素
		Collection c = new ArrayList();
		c.add(new Person(100, "狗娃"));
		c.add(new Person(101, "小明"));
		c.add(new Person(102, "小红"));

		System.out.println("存在该元素吗?" + c.contains(new Person(100, "狗娃")));

		System.out.println("集合的元素:" + c);
	}
}

class Person {
	int id;
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "{编号=" + id + ", 姓名=" + name + "}";
	}

	// java规范，一般重写了equals方法的话，会同时重写hashCode方法
	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.id == p.id;
	}

}
