package org.feng.algorithm.sort;

public class SortMain {

	public static void main(String [] argv) {
		int [] testValues1 = new int [] {
				10, 23, 31, 6, 71, 56, 43, 52, 22, 98, 2, 16
		};
		
		int [] testValues2 = new int [] {
				53, 23, 17, 3, 16, 22, 68, 93, 11, 26, 1, 33
		};
		
		int [] testValues3 = new int [] {
				96, 56, 16
		};
		
//		Sort sort = new QuickSort();
//		Sort sort = new MergeSort();
//		Sort sort = new InsertionSort();
//		Sort sort = new HeapSort();
		Sort sort = new TreeSort();
		
		sort.sort(testValues1);
		printArray(testValues1);

		sort.sort(testValues2);
		printArray(testValues2);
		
		sort.sort(testValues3);
		printArray(testValues3);

	}
	
	static void printArray(int [] values) {
		for(int value : values) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
}
