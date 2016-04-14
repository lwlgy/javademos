package cn.lwl.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/*
	ʹ��LinkedList�洢һ���˿��ƣ�ʵ��ϴ�ƹ���
	52��
	
 */
public class Poker {

	public static void main(String[] args) {
		LinkedList pokers = new LinkedList();
		for (int i = 0; i < 13; i++) {
			for(int r=0;r<4;r++){
				PokerInfo poker = new PokerInfo(i+1,r);
				pokers.add(poker);
			}
		}
		
		pokers = shuffle(pokers);
		
		System.out.println("Count:"+pokers.size() + pokers);
	}
	
	// ϴ��
	static LinkedList shuffle(LinkedList list){
		Random random = new Random();
		LinkedList retList = new LinkedList();
		int size = list.size();
		while( size > 0){
			int index = random.nextInt(list.size());
			retList.add(list.get(index));
			list.remove(index);
			size = list.size();
		}
		return retList;
	}
	
}

class PokerInfo{
	int num;
	int flag; // 0--����  1--����  2--��Ƭ  3--÷��
	public PokerInfo(int num, int flag) {
		this.num = num;
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "[����=" + num + ", ��ɫ=" + flag + "]\r\n";
	}
	
}