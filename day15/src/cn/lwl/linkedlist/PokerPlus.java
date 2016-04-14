package cn.lwl.linkedlist;

import java.util.LinkedList;
import java.util.Random;

/*
 这种方式消耗的资源较少
 */
public class PokerPlus {

	public static void main(String[] args) {
		String[] nums = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };
		String[] colors = { "黑桃", "红桃", "方片", "梅花" };
		LinkedList pokers = new LinkedList();
		for(String num : nums){
			for (String color : colors) {
				pokers.add(new PokerInfoPlus(num,color));
			}
		}
		System.out.println(pokers);
		shuffle(pokers);
		System.out.println(pokers);
	}
	
	public static void shuffle(LinkedList pokers){
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int index1 = random.nextInt(pokers.size());
			int index2 = random.nextInt(pokers.size());
			Object poker1 = pokers.get(index1);
			Object poker2 = pokers.get(index2);
			pokers.set(index1, poker2);
			pokers.set(index2, poker1);
			
		}
	}
}

class PokerInfoPlus {
	String num;
	String color;

	public PokerInfoPlus(String num, String color) {
		this.num = num;
		this.color = color;
	}

	@Override
	public String toString() {
		return "{" + color + num + "}";
	}

}