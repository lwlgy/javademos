package cn.lwl.linkedlist;

import java.util.LinkedList;

/*
	ʹ��LinkedListģ���ջ�ṹ�Ĵ洢��ʽ
	�Ƚ����
	push()
	pop()
*/
public class Stack {

	public static void main(String[] args) {

	}
}

class MyStackLinkedList{
	LinkedList list;

	public MyStackLinkedList() {
		list = new LinkedList();
	}
	
	public void add(Object item){
		list.push(item);
	}
	
	public Object remove(){
		return list.pop();
	}
	
	private int size() {
		return list.size();
	}
}