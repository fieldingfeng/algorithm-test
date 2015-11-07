package org.feng.algorithm.sort;

import org.feng.algorithm.sort.AVLTree.Node;

public class TreeSort implements Sort {

	@Override
	public void sort(int[] values) {
		AVLTree tree = new AVLTree();
		for(int value : values) {
			tree.insert(value);
		}
		
		populateValue(tree.root, new ArrayStack(values));
	}

	private void populateValue(Node node, ArrayStack stack) {
		if(node == null) {
			return;
		} else {
			populateValue(node.left, stack);
			stack.put(node.value);
			populateValue(node.right, stack);
		}
	}
	
	class ArrayStack {
		int [] values;
		int index;
		
		public ArrayStack(int[] values) {
			super();
			this.values = values;
			this.index = 0;
		}
		
		public void put(int i) {
			values[index++] = i;
		}
	}

}
