import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		BinaryNode<T> currentNode = getRootNode();
		BinaryNode<T> newNode = new BinaryNode<T>(newEntry);
		while(currentNode != null) {
			T data = currentNode.getData();
			int comparison = data.compareTo(newEntry);
			if (comparison >= 0) {
				BinaryNode<T> leftChild = currentNode.getLeftChild();
				if (leftChild == null) {
					currentNode.setLeftChild(newNode);
					break;
				} else {
					currentNode = leftChild;
				}
			} else if (comparison < 0) {
				BinaryNode<T> rightChild = currentNode.getRightChild();
				if (rightChild == null) {
					currentNode.setRightChild(newNode);
					break;
				} else {
					currentNode = rightChild;
				}
			}
		}
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = getRootNode();
		while (currentNode != null) {
			T data = currentNode.getData();
			int comparison = data.compareTo(target);
			if (comparison == 0) {
				count++;
			}
			if (comparison >= 0) {
				currentNode = currentNode.getLeftChild();
			} else {
				currentNode = currentNode.getRightChild();
			}
		}
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		BinaryNode<T> rootNode = getRootNode();
		return countGreaterRecursiveHelper(rootNode, target);
	}

	private int countGreaterRecursiveHelper(BinaryNode<T> node, T target) {
		if (node == null) {
			return 0;
		}
		T data = node.getData();
		int comparison = data.compareTo(target);
		BinaryNode<T> rightChild = node.getRightChild();
		if (comparison <= 0) {
			return countGreaterRecursiveHelper(rightChild, target);
		} else {
			BinaryNode<T> leftChild = node.getLeftChild();
			return 1 + countGreaterRecursiveHelper(leftChild, target) + countGreaterRecursiveHelper(rightChild, target);
		}
	}

	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE!
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		nodeStack.push(rootNode);
		while (!nodeStack.empty()) {
			BinaryNode<T> node = nodeStack.pop();
			if (node != null) {
				T data = node.getData();
				int comparison = target.compareTo(data);
				if (comparison < 0) {
					count++;
					nodeStack.push(node.getLeftChild());
					nodeStack.push(node.getRightChild());
				} else {
					nodeStack.push(node.getRightChild());
				}
			}
		}
		return count;
	}

	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n).
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR RECURSIVE.
	public int countUniqueValues() {
		/* USING AN ITERATOR */
		int count = 0;
		Iterator<T> iterator = getInorderIterator();
		T last = null;
		while (iterator.hasNext()) {
			T data = iterator.next();
			if (!data.equals(last)) {
				count++;
				last = data;
			}
		}
		return count;

		/* USING A SET TO KEEP TRACK */
		// BinaryNode<T> rootNode = getRootNode();
		// Set<T> set = new HashSet<T>();
		// Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		// nodeStack.push(rootNode);
		// while (!nodeStack.empty()) {
		// 	BinaryNode<T> node = nodeStack.pop();
		// 	set.add(node.getData());
		// 	BinaryNode<T> left = node.getLeftChild();
		// 	BinaryNode<T> right = node.getRightChild();
		// 	if (left != null) {
		// 		nodeStack.push(left);
		// 	}
		// 	if (right != null) {
		// 		nodeStack.push(right);
		// 	}
		// }
		// return set.size();
	}

	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}



}