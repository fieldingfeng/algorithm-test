package org.feng.algorithm.sort;

public class AVLTree {
	Node root;
	
	public Node insert(int value) {
		Node node = new Node(value);
		
		if(root == null) {
			root = node;
		} else {
			insert(root, node);
		}
		
//		print(root, 0);
//		System.out.println("---------------------");
		
		
		return node;
	}
	
	private void insert(Node parent, Node node) {
		if(parent.value > node.value) {
			if(parent.left == null) {
				parent.left = node;
				node.parent = parent;
			} else {
				insert(parent.left, node);
			}
		} else {
			if(parent.right == null) {
				parent.right = node;
				node.parent = parent;
			} else {
				insert(parent.right, node);
			}
		}
		
		rebalance(parent);
	}

	private void rebalance(Node parent) {
		if(parent != null) {
			if(balanceFactor(parent) == 2) {
				if(balanceFactor(parent.left) == -1) {
					rotateLeft(parent.left);
					rotateRight(parent);
				} else if(balanceFactor(parent.left) == 1) {
					rotateRight(parent);
				}
			} else if(balanceFactor(parent) == -2) {
				if(balanceFactor(parent.right) == 1) {
					rotateRight(parent.right);
					rotateLeft(parent);
				} else if(balanceFactor(parent.right) == -1) {
					rotateLeft(parent);
				}
			}
		}
	}

	public void rotateLeft(Node node) {
		Node r = node.right;
		Node p = node.parent;
		
		if(p != null) {
			if(p.left == node) {
				p.left = r;
			} else {
				p.right = r;
			}
		} else {
			root = r;
		}
		
		node.right = r.left;
		r.left = node;

		r.parent = p;
		node.parent = r;
		
		if(node.right != null) {
			node.right.parent = node;
		}
	}
	
	public void rotateRight(Node node) {
		Node p = node.parent;
		Node l = node.left;
		
		if(p != null) {
			if(p.left == node) {
				p.left = l;
			} else {
				p.right = l;
			}
		} else {
			root = l;
		}
		
		node.left = l.right;
		l.right = node;
		
		l.parent = p;
		node.parent = l;
		if(node.left != null) {
			node.left.parent = node;
		}
	}
	
	public int deep(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.deep();
	}
	
	public int balanceFactor(Node node) {
		if(node == null) {
			return 0;
		}
		
		int l = deep(node.left);
		int r = deep(node.right);
		
		return l - r;
	}

	public void print(Node node, int i) {
		if(node != null) {
			print(node.left, i + 2);
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println(node.value);
			print(node.right, i + 2);
		}
	}

	public static class Node {
		Node parent;
		Node left;
		Node right;
		int value;
		
		public Node(int value) {
			this.value = value;
		}

		public int deep() {
			return 1 + Math.max(left == null?0:left.deep(), right == null?0:right.deep());
		}
		
	}
}
