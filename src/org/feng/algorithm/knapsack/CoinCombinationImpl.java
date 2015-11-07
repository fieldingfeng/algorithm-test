package org.feng.algorithm.knapsack;

import java.util.ArrayList;
import java.util.List;

public class CoinCombinationImpl {
	public static int [] coinValues = new int[] {1, 5, 10, 25};
	
	public static void main(String [] args) {
		int amount = 98;

		int [] counts = new int[amount+1];
		
		for(int i = 1; i <= amount; i++) {
			int count = counts[i - 1];
			
			for(int j = 1; j < coinValues.length; j++) {
				
				if(coinValues[j] <= i) {
					if(i % coinValues[j] == 0) {
						count++;
					}
				} else {
					break;
				}
			}
			
			counts[i] = count;
		}
		
		System.out.println(counts[amount]);
	}
	
}
