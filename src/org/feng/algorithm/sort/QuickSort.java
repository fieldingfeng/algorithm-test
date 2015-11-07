package org.feng.algorithm.sort;

import java.util.Random;


public class QuickSort implements Sort {
	Random random = new Random();
	
	public void sort(int[] values) {
		
		quickSort(values, 0, values.length - 1);
	}

	private void quickSort(int [] values, int left, int right) {
		if(left < right) {
			int privotIndex = random.nextInt(right - left) + left;
			
			int newPrivotIndex = partition(values, left, right, privotIndex);
			quickSort(values, left, newPrivotIndex -1);
			quickSort(values, newPrivotIndex + 1, right);
		}
	}

	private int partition(int[] values, int left, int right, int privotIndex) {
		int privotValue = values[privotIndex];
		swap(values, privotIndex, right);  //move the privot value to the end.
		
		int newPrivotIndex = left;
		for(int i = left; i < right; i++) { // iterate the array, except the last value which is the privot value.
			if(values[i] <= privotValue) {
				swap(values, i, newPrivotIndex);
				newPrivotIndex++;
			}
		}
		swap(values, newPrivotIndex, right); // swap the value(this is larger than the privot value) on the new privot index with the privot value
		
		return newPrivotIndex;
	}

	private void swap(int[] values, int first, int second) {
		if(first != second) {
			int tmp = values[first];
			values[first] = values[second];
			values[second] = tmp;
		}
	}
	
	private void printArray(int [] values) {
		for(int value : values) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
