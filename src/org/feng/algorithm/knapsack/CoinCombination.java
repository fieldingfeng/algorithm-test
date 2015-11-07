package org.feng.algorithm.knapsack;

public class CoinCombination {
	public static int [] coinValues = new int[] {1, 5, 10, 25};
	private static int count = 0;
	
	public static void main(String [] args) {
		int amount = 100;

		int [] combination = new int [4];
		count(combination, amount, coinValues.length - 1);
		
		System.out.println(count);
	}
	
	public static void count(int [] combination, int total, int type) {
		int t = total;
		int c = 0;
		while(t > 0) {
			combination[type] = c;
			if(type > 0) {
				count(combination, t, type - 1);
			}
			t = t - coinValues[type];
			c++;
		}
		
		if(t == 0) {
			combination[type] = c;
			print(combination);
			count++;
		}
		
		//reset current value
		combination[type] = 0;
	}

	private static void print(int[] combination) {
		for(int i = 0; i < combination.length; i++) {
			System.out.print(combination[i] + "\t");
		}
		System.out.println();
	}
}
