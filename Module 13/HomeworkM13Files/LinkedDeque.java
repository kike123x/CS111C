/**
 * A class that implements the ADT deque by using a doubly linked chain of
 * nodes.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public final class LinkedDeque<T> implements DequeInterface<T> {
	private DLNode firstNode; // References node at front of deque
	private DLNode lastNode; // References node at back of deque

	public LinkedDeque() {
		firstNode = null;
		lastNode = null;
	} // end default constructor

	public void addToBack(T newEntry) {
		DLNode newNode = new DLNode(lastNode, newEntry, null);

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);

		lastNode = newNode;
	} // end addToBack

	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(null, newEntry, firstNode);

		if (isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);

		firstNode = newNode;
	} // end addToFront

	public T getBack() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return lastNode.getData();
	} // end getBack

	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	} // end getFront

	public T removeFront() {
		T front = getFront(); // Might throw EmptyQueueException
		assert (firstNode != null);
		firstNode = firstNode.getNextNode();

		if (firstNode == null)
			lastNode = null;
		else
			firstNode.setPreviousNode(null);

		return front;
	} // end removeFront

	public T removeBack() {
		T back = getBack(); // Might throw EmptyQueueException
		assert (lastNode != null);
		lastNode = lastNode.getPreviousNode();

		if (lastNode == null)
			firstNode = null;
		else
			lastNode.setNextNode(null);

		return back;
	} // end removeBack

	public void clear() {
		firstNode = null;
		lastNode = null;
	} // end clear

	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	} // end isEmpty

	// public void display() {
	// 	DLNode current = firstNode;
	// 	// System.out.printf("First Node: %s, [", firstNode.data);

	// 	while (current != null) {
	// 		System.out.print(current.data + " ");
	// 		current = current.next;
	// 	}
	// 	// System.out.printf("] Last Node: %s", lastNode.data);
	// 	System.out.println();
	// }

	private class DLNode {
		private T data; // Deque entry
		private DLNode next; // Link to next node
		private DLNode previous; // Link to previous node

		private DLNode(T dataPortion) {
			data = dataPortion;
			next = null;
			previous = null;
		} // end constructor

		private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private DLNode getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(DLNode nextNode) {
			next = nextNode;
		} // end setNextNode

		private DLNode getPreviousNode() {
			return previous;
		} // end getPreviousNode

		private void setPreviousNode(DLNode previousNode) {
			previous = previousNode;
		} // end setPreviousNode
	} // end DLNode
} // end LinkedDeque
