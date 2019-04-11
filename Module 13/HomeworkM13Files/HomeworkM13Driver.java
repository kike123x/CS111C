import java.util.*;

public class HomeworkM13Driver {

	public static void main(String[] args) {

		// System.out.println("*****TESTING CLIENT VIEW SPLICE");
		// QueueInterface<Integer> q1 = new LinkedQueue<Integer>();
		// QueueInterface<Integer> q2 = new LinkedQueue<Integer>();
		// splice(q1, q2);
		// System.out.println("q1 empty: \ntrue\n" + q1.isEmpty());
		// System.out.println("q2 empty: \ntrue\n" + q2.isEmpty());
		// q1.enqueue(4);
		// q1.enqueue(8);
		// q1.enqueue(9);
		// q1.enqueue(2);
		// splice(q1, q2);
		// System.out.println("\nq1 contains: \n4 8 9 2");
		// ((LinkedQueue<Integer>)q1).display();
		// System.out.println("q2 still empty: \ntrue\n" + q2.isEmpty());

		// q2.enqueue(1);
		// q2.enqueue(3);
		// q2.enqueue(7);
		// q2.enqueue(6);
		// q2.enqueue(3);
		// q2.enqueue(1);
		// splice(q1, q2);
		// System.out.println("\nq1 contains: \n4 8 9 2 1 3 7 6 3 1");
		// ((LinkedQueue<Integer>)q1).display();
		// System.out.println("q2 still contains: \n1 3 7 6 3 1");
		// ((LinkedQueue<Integer>)q2).display();

		System.out.println("\n\n*****TESTING ARRAYQUEUE SPLICE");
		// ArrayQueue<String> sample = new ArrayQueue<String>(7);
		// sample.display();
		// sample.enqueue("1");
		// sample.enqueue("2");
		// sample.enqueue("3");
		// sample.enqueue("4");
		// sample.dequeue();
		// sample.enqueue("5");
		// sample.enqueue("6");
		// sample.enqueue("7");
		// sample.enqueue("8");
		// sample.dequeue();
		// sample.enqueue("9");
		// sample.dequeue();
		// sample.dequeue();
		// sample.dequeue();
		// sample.dequeue();
		// sample.dequeue();
		// sample.dequeue();
		// sample.dequeue();
		// sample.dequeue();



		// ArrayQueue<String> wordQueue1 = new ArrayQueue<String>();
		// ArrayQueue<String> wordQueue2 = new ArrayQueue<String>();
		// wordQueue1.splice(wordQueue2);
		// System.out.println("wordQueue1 empty: \ntrue\n" + wordQueue1.isEmpty());
		// System.out.println("wordQueue2 empty: \ntrue\n" + wordQueue2.isEmpty());
		// wordQueue1.enqueue("a");
		// wordQueue1.enqueue("b");
		// wordQueue1.enqueue("c");
		// wordQueue1.enqueue("a");
		// wordQueue1.splice(wordQueue2);
		// System.out.println("\nwordQueue1 contains: \na b c a");
		// wordQueue1.display();
		// System.out.println("wordQueue2 still empty: \ntrue\n" + wordQueue2.isEmpty());
		// wordQueue2.enqueue("d");
		// wordQueue2.enqueue("e");
		// wordQueue2.enqueue("f");
		// wordQueue2.enqueue("e");
		// wordQueue1.splice(wordQueue2);
		// System.out.println("\nwordQueue1 contains: \na b c a d e f e");
		// wordQueue1.display();
		// System.out.println("wordQueue2 still contains: \nd e f e");
		// wordQueue2.display();


		// ArrayQueue<Integer> aq1 = new ArrayQueue<Integer>(4);
		// aq1.enqueue(99);
		// aq1.enqueue(99);
		// aq1.enqueue(99);
		// aq1.enqueue(4);
		// aq1.dequeue(); // these lines included so that the contents of the array wrap around for testing purposes
		// aq1.dequeue();
		// aq1.dequeue();
		// aq1.enqueue(8);
		// aq1.enqueue(9);
		// aq1.enqueue(2);

		// ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>(4);
		// aq2.enqueue(99);
		// aq2.enqueue(99);
		// aq2.enqueue(99);
		// aq2.enqueue(1);
		// aq2.dequeue(); // these lines included so that the contents of the array wrap around for testing purposes
		// aq2.dequeue();
		// aq2.dequeue();
		// aq2.enqueue(3);
		// aq2.enqueue(7);
		// aq2.enqueue(6);

		// aq1.splice(aq2);
		// System.out.println("\nq1 contains: \n4 8 9 2 1 3 7 6");
		// aq1.display();
		// System.out.println("q2 still contains: \n1 3 7 6");
		// aq2.display();

		// System.out.println("\n\n*****TESTING LINKEDQUEUE SPLICE");
		// LinkedQueue<Integer> lq1 = new LinkedQueue<Integer>();
		// LinkedQueue<Integer> lq2 = new LinkedQueue<Integer>();
		// lq1.splice(lq2);
		// System.out.println("lq1 empty: \ntrue\n" + lq1.isEmpty());
		// System.out.println("lq2 empty: \ntrue\n" + lq2.isEmpty());
		// lq1.enqueue(4);
		// lq1.enqueue(8);
		// lq1.enqueue(9);
		// lq1.enqueue(2);
		// lq1.splice(lq2);
		// System.out.println("\nlq1 contains: \n4 8 9 2");
		// lq1.display();
		// System.out.println("lq2 still empty (and no exception thrown): \ntrue\n" + lq2.isEmpty());

		// lq2.enqueue(1);
		// lq2.enqueue(3);
		// lq2.enqueue(7);
		// lq2.enqueue(6);
		// lq1.splice(lq2);
		// System.out.println("\nq1 contains: \n4 8 9 2 1 3 7 6");
		// lq1.display();
		// System.out.println("q2 still contains: \n1 3 7 6");
		// lq2.display();

		// System.out.println("\n\n*****TESTING DEQUESTACK");
		// DequeStack<Integer> stack = new DequeStack<Integer>();
		// System.out.println("isEmpty? true: " + stack.isEmpty());
		// stack.push(1);
		// stack.push(2);
		// stack.push(3);
		// stack.push(4);
		// System.out.println("isEmpty? false: " + stack.isEmpty());
		// stack.push(5);
		// stack.push(6);
		// // System.out.println("Stack contains: \n6 5 4 3 2 1");
		// // stack.display();
		// System.out.println("Peek 6: " + stack.peek());
		// System.out.println("Pop 6: " + stack.pop());
		// System.out.println("Peek 5: " + stack.peek());
		// System.out.println("Pop 5: " + stack.pop());
		// // System.out.println("Stack contains: \n4 3 2 1");
		// // stack.display();
		// stack.push(20);
		// System.out.println("Peek 20: " + stack.peek());
		// stack.push(40);
		// System.out.println("Peek 40: " + stack.peek());
		// // System.out.println("Stack contains: \n40 20 4 3 2 1");
		// // stack.display();
		// stack.clear();
		// System.out.println("isEmpty? true: " + stack.isEmpty());
		// // System.out.println("Pop Empty: " + stack.pop());
		// // System.out.println("Peek Empty: " + stack.peek());


		System.out.println("\n\n*****TESTING LISTDEQUE");
		ListDeque<Integer> deque = new ListDeque<Integer>();
		System.out.println("isEmpty? true: " + deque.isEmpty());
		deque.addToFront(2);
		deque.addToFront(1);
		deque.addToBack(3);
		deque.addToBack(4);
		// deque.display();
		System.out.println("isEmpty? false: " + deque.isEmpty());
		System.out.println("getFront 1: " + deque.getFront());
		System.out.println("removeFront 1: " + deque.removeFront());
		// deque.display();
		System.out.println("getBack 4: " + deque.getBack());
		System.out.println("removeBack 4: " + deque.removeBack());
		// deque.display();
		System.out.println("getFront 2: " + deque.getFront());
		System.out.println("removeFront 2: " + deque.removeFront());
		// deque.display();
		System.out.println("getBack 3: " + deque.getBack());
		System.out.println("isEmpty? false: " + deque.isEmpty());
		deque.clear();
		// deque.display();
		System.out.println("isEmpty? true: " + deque.isEmpty());




	}

	// note: don't worry about generics here; i've omitted them and supressed the
	// warnings so you can focus on the queue logic
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void splice(QueueInterface firstQueue, QueueInterface secondQueue) {
		QueueInterface tempQueue = new LinkedQueue<>();
		while(!secondQueue.isEmpty()) {
			Object item = secondQueue.dequeue();
			firstQueue.enqueue(item);
			tempQueue.enqueue(item);
		}
		while(!tempQueue.isEmpty()) {
			secondQueue.enqueue(tempQueue.dequeue());
		}
 	}

}