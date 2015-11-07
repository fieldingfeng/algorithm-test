package org.feng.algorithm.sort;

public class MergeSort implements Sort {

	public void sort(int[] values) {
		int [] workingArray = new int[values.length];
		
		mergeSort(values, workingArray, 0, values.length);
	}

	private void mergeSort(int[] values, int[] workingArray, int begin, int end) {
		if(end - begin >= 2) {
			int middle = (begin + end) / 2;
			mergeSort(values, workingArray, begin, middle);
			mergeSort(values, workingArray, middle, end);
			sort(values, begin, middle, end);
//			sort(values, workingArray, begin, middle, end);
		}
		
	}

	private void sort(int[] values, int begin, int middle,
			int end) {
		
		int valueOneIndex = begin;
		int valueTwoIndex = middle;
		
		for(int i = begin; i < end; i++) {			
			if(valueOneIndex == middle) {
				return;
			} if(valueTwoIndex == end) {
				return;
			} else if(values[valueOneIndex] > values[valueTwoIndex]) {
				int tmp = values[valueTwoIndex];
				for(int j = valueTwoIndex; j > i; j--) {
					values[j] = values[j-1];
				}
				values[i] = tmp;
				middle++;
				valueOneIndex++;
				valueTwoIndex++;
			} else {
				valueOneIndex++;
			}
		}
	}
	
	private void sort(int[] values, int[] workingArray, int begin, int middle,
			int end) {
		
		int valueOneIndex = begin;
		int valueTwoIndex = middle;
		
		for(int i = begin; i < end; i++) {			
			if(valueOneIndex == middle) {
				workingArray[i] = values[valueTwoIndex++];
			} else if (valueTwoIndex == end) {
				workingArray[i] = values[valueOneIndex++];
			} else if(values[valueOneIndex] > values[valueTwoIndex]) {
				workingArray[i] = values[valueTwoIndex++];
			} else {
				workingArray[i] = values[valueOneIndex++];
			}
//			if(valueOneIndex < middle && 
//					(valueTwoIndex >= end || values[valueOneIndex] < values[valueTwoIndex])) {
//				workingArray[i] = values[valueOneIndex++];
//			} else {
//				workingArray[i] = values[valueTwoIndex++];
//			}
		}
		
		copyArray(workingArray, values, begin, end);
		
	}

	void copyArray(int [] source, int [] target, int begin, int end) {
		for(int i = begin; i < end; i++) {
			target[i] = source[i];
		}
	}
}
