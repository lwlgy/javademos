package cn.lwl.linkedlist;

import java.util.LinkedList;

/*
 	ʹ��LinkedListģ����нṹ�Ĵ洢��ʽ
	�Ƚ��ȳ�
	offer()	��ָ��Ԫ����ӵ����б��ĩβ
	poll()	��ȡ���Ƴ����б��ͷ
*/
public class Queue {
	
	public static void main(String[] args) {
		
	}
}

class MyQueueLinkedList{
	LinkedList list;
	
	public MyQueueLinkedList() {
		list = new LinkedList();
	}

	public void add(Object item){
		list.offer(item);
	}
	
	public Object remove(){
		return list.poll();
	}
	
	private int size() {
		return list.size();
	}
}