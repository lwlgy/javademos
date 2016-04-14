package cn.lwl.linkedlist;

import java.util.LinkedList;

/*
 	使用LinkedList模拟队列结构的存储方式
	先进先出
	offer()	将指定元素添加到此列表的末尾
	poll()	获取并移除此列表的头
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