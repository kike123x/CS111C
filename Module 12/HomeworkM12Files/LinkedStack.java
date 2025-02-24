import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedStack<T> implements StackInterface<T> {

	private Node topNode; // References the first node in the chain

	public LinkedStack() {
		topNode = null;
	} // end default constructor

	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
//    topNode = new Node(newEntry, topNode); // Alternate code
	} // end push

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	} // end peek

	public T pop() {
		T top = peek(); // Might throw EmptyStackException
		// Assertion: topNode != null
		topNode = topNode.getNextNode();

		return top;
	} // end pop

	public boolean isEmpty() {
		return topNode == null;
	} // end isEmpty

	public void clear() {
		topNode = null; // Causes deallocation of nodes in the chain
	} // end clear



	@Override
	public String toString() {
		String s = "";
		Node current = topNode;
		while (current != null) {
			s = current.data + " " + s;
			current = current.next;
		}
		return s;
	}

	public boolean priorityPush(T element) {
		if (topNode == null) {
			push(element);
			return false;
		}
		T topData = topNode.getData();
		if (topData.equals(element)) {
			return true;
		} else {
			Node previousNode = topNode;
			Node currentNode = topNode.getNextNode();
			while (currentNode != null) {
				T data = currentNode.getData();
				if (data.equals(element)) {
					previousNode.setNextNode(currentNode.getNextNode());
					currentNode.setNextNode(topNode);
					topNode = currentNode;
					return true;
				} else {
					previousNode = previousNode.getNextNode();
					currentNode = currentNode.getNextNode();
				}
			}
			push(element);
			return false;
		}
	}

	// LinkedStack
	public T peekNext() {
		if (isEmpty())
			throw new EmptyStackException();
		else if (topNode.next == null)
			return null;
		else
			return topNode.next.data;
	}

	private class Node {
		private T data; // Entry in stack
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

} // end LinkedStack