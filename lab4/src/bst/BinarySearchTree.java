package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTVisualizer w = new BSTVisualizer("Trä", 700, 700);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(20);
		tree.add(7);
		tree.add(8);
		System.out.println(tree.height());
		tree.printTree();
		System.out.println("");
		System.out.println(tree.size());
		Integer[] a = new Integer[tree.size()];
		tree.toArray(tree.root, a, 0);
		for (Integer i : a) {
			System.out.println(i);
			tree.rebuild();
		}
		w.drawTree(tree);

		// BSTVisualizer test = new BSTVisualizer("fak", 300, 300);
		// test.drawTree(tree);
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		return add(x, root);
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return calcHeight(root);
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size()];
		toArray(root, a, 0);
		root = buildTree(a, 0, size() - 1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1
	 * (the first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n != null) {
			index = toArray(n.left, a, index);
			a[index] = n.element;
			index++;
			index = toArray(n.right, a, index);
		}
		return index;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in
	 * the array a are assumed to be in ascending order. Returns the root of
	 * tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int midIndex = (first + last) / 2;
		add(a[midIndex]);

		return buildTree(a, 0, midIndex - 1);

		//return buildTree(a, midIndex + 1, last);

		//return root;
	}

	private void printTree(BinaryNode<E> n) {
		if (n != null) {
			printTree(n.left);
			System.out.print(n.element + " ");
			printTree(n.right);
		}

	}

	private boolean add(E x, BinaryNode<E> n) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		if (n.element.compareTo(x) > 0) {
			if (n.left == null) {
				n.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return add(x, n.left);
		} else if (n.element.compareTo(x) < 0) {
			if (n.right == null) {
				n.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return add(x, n.right);

		}

		return false;

	}

	private int calcHeight(BinaryNode<E> Node) {
		if (Node == null) {
			return 0;
		}

		if (calcHeight(Node.left) < calcHeight(Node.right)) {
			return calcHeight(Node.right) + 1;
		}
		return calcHeight(Node.left) + 1;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

}
