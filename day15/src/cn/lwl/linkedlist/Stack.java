package cn.lwl.linkedlist;

import java.util.LinkedList;

/*
	使用LinkedList模拟堆栈结构的存储方式
	先进后出
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