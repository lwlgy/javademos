package cn.lwl.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/*
	使用LinkedList存储一副扑克牌，实现洗牌功能
	52张
	
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
	
	// 洗牌
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
	int flag; // 0--黑桃  1--红桃  2--方片  3--梅花
	public PokerInfo(int num, int flag) {
		this.num = num;
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "[数字=" + num + ", 花色=" + flag + "]\r\n";
	}
	
}