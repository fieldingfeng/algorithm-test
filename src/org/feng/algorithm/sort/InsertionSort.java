package org.feng.algorithm.sort;

public class InsertionSort implements Sort {

	@Override
	public void sort(int[] values) {
		for(int i = 1; i < values.length; i++) {
			int currentValue = values[i];
			for(int j = i-1; j >= 0; j--) {
				if(values[j] > currentValue) {
					values[j+1] = values[j];
					if(j == 0) {
						values[j] = currentValue;
					}
				} else {
					values[j+1] = currentValue;
					break;
				}
			}
		}
	}

}
