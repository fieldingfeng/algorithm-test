package org.feng.algorithm.knapsack;

public class Coin {
	public static void main(String [] args) {
		int amount = 98;
		int [] coinValues = new int[] {1, 5, 10, 25};
		int [] count = new int[coinValues.length];
		
		int total = amount;
		int index = coinValues.length - 1;
		while(total != 0) {
			if(total >= coinValues[index]) {
				total = total - coinValues[index];
				count[index]++;
			} else {
				index--;
			}
		}
		
		
		for(int c : count) {
			System.out.print(c + "\t");
		}
	}
	
}
