package cn.lwl.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
 * ���ϣ������Ǵ洢�������ݵļ���������
 * 
 * ���������������ƣ�
 * 		1.���Ͽ��Դ洢�������͵Ķ������ݣ�����ֻ�ܴ洢ͬһ���������͵����ݡ�
 * 		2.���ϵĳ����ǿɱ�ģ�����ĳ����ǹ̶��ġ�
 * 
 * ------------| Collection	�������ϵĸ��ӿ�
 * -----------------| List	�����ʵ����List�ӿڵļ����࣬�߱����ص��ǣ����򣬿��ظ�
 * -----------------| Set	�����ʵ����Set�ӿڵļ����࣬�߱����ص��ǣ����򣬲����ظ�
 * 
 * Collection�еķ�����
 * 		���ӣ�
 * 			add(E e)								��ӳɹ�����true�����ʧ�ܷ���false
 * 			addAll(Collection<Object> c) 			��һ�������е�Ԫ����ӵ���һ��������
 * 		ɾ����
 * 			clear() 
 * 			remove(Object o) 
 * 			removeAll(Collection<?> c) 
 * 			retainAll(Collection<?> c) 
 * 		�鿴��
 *			size()
 * 		�жϣ�
 * 			contains(Object o) 
 * 			containsAll(Collection<?> c)
 *			isEmpty()
 * 		������
 *			toArray()			 
 * 			iterator() 

 */
public class Demo1 {
	public static void main(String[] args) {
		/*
		 * Collection c = new ArrayList(); // c.add("abc"); // c.add(1); //
		 * c.add(3.14); c.add("��ƻ�"); c.add("��ź�"); c.add("������"); //
		 * System.out.println("��ӳɹ���?"+c.add("������"));
		 */
		/*
		 * Collection c2 = new ArrayList(); c2.add("���»�"); c2.add("��ѧ��");
		 * c2.add("������"); c2.add("����");
		 * 
		 * c.addAll(c2); // ��c2�е�Ԫ����ӵ�c��
		 */
		// c.clear();// ��ռ����е�Ԫ��

		// System.out.println("ɾ���ɹ���?"+c.remove("�ƻ�"));
		// System.out.println("ɾ���ɹ���?"+c.remove("��ƻ�"));

		/*
		 * Collection c2 = new ArrayList(); c2.add("��ƻ�"); c2.add("��ź�");
		 * c2.add("������"); c2.add("����"); c.removeAll(c2);// ɾ��c����c2�Ľ���Ԫ��
		 */

		/*
		 * Collection c2 = new ArrayList(); c2.add("��ƻ�"); c2.add("��ź�");
		 * c2.add("������"); c2.add("����"); c.retainAll(c2);// ����c����c2�Ľ���Ԫ�أ�ɾ������Ԫ��
		 */
		/*
		 * c.clear(); System.out.println("�����Ԫ�ظ�����:"+c.size());
		 */

		/*
		 * // c.clear(); System.out.println("�����Ƿ�Ϊ��Ԫ��?" + c.isEmpty());
		 */

		// System.out.println("�������Ƿ������Ӧ��Ԫ��?"+c.contains("��ź�"));

		// ����Զ���Ԫ��
		Collection c = new ArrayList();
		c.add(new Person(100, "����"));
		c.add(new Person(101, "С��"));
		c.add(new Person(102, "С��"));

		System.out.println("���ڸ�Ԫ����?" + c.contains(new Person(100, "����")));

		System.out.println("���ϵ�Ԫ��:" + c);
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
		return "{���=" + id + ", ����=" + name + "}";
	}

	// java�淶��һ����д��equals�����Ļ�����ͬʱ��дhashCode����
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
