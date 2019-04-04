public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {
  private Node head, tail;
  private int numberOfElements;

  public LinkedHeadTailList() {
    head = null;
    tail = null;
    numberOfElements = 0;
  }

  public void addFront(T newEntry) {
    if (newEntry != null) {
      Node newNode = new Node(newEntry, head);
      head = newNode;
      if (tail == null) tail = newNode;
      numberOfElements++;
    }
  }

  public void addBack(T newEntry) {
    if (newEntry != null) {
      Node newNode = new Node(newEntry);
      if (tail == null) { // head must also be null
        head = newNode;
      } else {
        tail.next = newNode;
      }
      tail = newNode;
      numberOfElements++;
    }
  }

  public T removeFront() {
    if (head != null) {
      Node temp = head;
      head = head.next;
      numberOfElements--;
      if (numberOfElements == 0) {
        tail = null;
      }
      return temp.data;
    }
    return null;
  }

  public T removeBack() {
    if (numberOfElements == 1) {
      head = null;
      Node temp = tail;
      tail = null;
      numberOfElements--;
      return temp.data;
    } else if (numberOfElements > 1) {
      Node currentNode = head;
      int index = 0;
      while (index < numberOfElements - 2) {
        currentNode = currentNode.next;
        index++;
      }
      Node temp = currentNode.next;
      currentNode.next = null;
      numberOfElements--;
      tail = currentNode;
      return temp.data;
    }
    return null;
  }

  public void clear() {
    head = null;
    tail = null;
    numberOfElements = 0;
  }

  public T getEntry(int givenPosition) {
    if (givenPosition == numberOfElements - 1) {
      return tail.data;
    } else if (givenPosition >= 0 && givenPosition < numberOfElements-1) {
      Node currentNode = head;
      int index = 0;
      while (index < numberOfElements-1) {
        if (index == givenPosition) return currentNode.data;
        currentNode = currentNode.next;
        index++;
      }
    }
    return null;
  }

  public void display() {
    System.out.print("[");
    Node currentNode = head;
    while (currentNode != null) {
      System.out.print(currentNode.data);
      if (currentNode.next != null) System.out.print(", ");
      currentNode = currentNode.next;
    }
    System.out.print("]");
    if (numberOfElements > 0) {
      System.out.print("\thead=" + head.data + "\ttail=" + tail.data);
    }
    System.out.println();
  }

  public int contains(T anEntry) {
    Node currentNode = head;
    int index = 0;
    while (currentNode != null) {
      if (currentNode.data.equals(anEntry)) return index;
      currentNode = currentNode.next;
      index++;
    }
    return -1;
  }

  public int size() {
    return numberOfElements;
  }

  public boolean isEmpty() {
    return numberOfElements == 0;
  }

  public int compareTo(LinkedHeadTailList<T> otherList)  {
    Node thisCurrent = head;
    Node otherCurrent = otherList.head;
    while (thisCurrent != null && otherCurrent != null) {
      int result = thisCurrent.data.compareTo(otherCurrent.data);
      if (result == 0) {
        thisCurrent = thisCurrent.next;
        otherCurrent = otherCurrent.next;
      } else {
        return result;
      }
    }
    if (thisCurrent == null && otherCurrent == null) {
      return 0;
    } else {
      return numberOfElements - otherList.numberOfElements;
    }
  }

  private class Node {
		private T data; // Entry in list
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
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
  }
}