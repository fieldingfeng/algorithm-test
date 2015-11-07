package org.feng.algorithm.sort;

public class HeapSort implements Sort {

	@Override
	public void sort(int[] values) {
		int length = values.length;
		
		heapify(values, length);
		int end = length - 1;
		
		while(end > 0) {
			swap(values, end, 0);
			end = end - 1;
			shiftDown(values, 0, end);
		}
	}

	private void shiftDown(int[] values, int start, int end) {
		int root = start;
		while( root * 2 + 1 <= end) {
			int child = root * 2 + 1;
			int swap = root;
			
			if(values[swap] < values[child]) {
				swap = child;
			}
			
			if(child + 1 <= end && values[swap] < values[child+1]) {
				swap = child + 1;
			}
			
			if(swap == root) {
				return;
			} else {
				swap(values, root, swap);
				root = swap;
			}
		}
	}

	private void swap(int[] values, int end, int i) {
		int temp = values[end];
		
		values[end] = values[i];
		values[i] = temp;
		
	}

	private void heapify(int[] values, int length) {
		int start = (length - 2) / 2;
		
		while(start >= 0) {
			shiftDown(values, start, length - 1);
			start = start - 1;
		}
		
	}

}
