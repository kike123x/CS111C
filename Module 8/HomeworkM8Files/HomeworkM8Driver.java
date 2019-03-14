import java.text.NumberFormat;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HomeworkM8Driver {

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getPercentInstance();

		System.out.println("*********************Array Sortedness Tester");
		Integer[] array1 = {1, 2, 3, 3, 5};
		Integer[] array2 = {1, 2, 3, 4, 5, 5};
		Integer[] array3 = {10, 8, 5, 3, 1};
		Integer[] array4 = {12, 11, 9, 3, 2, 1};
		Integer[] array5 = {2, 8, 3, 9, 6};
		Integer[] array6 = {7, 1, 6, 8, 5, 2};
		String[] array7 = {"abc", "def", "ghi"};

		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortedness(array3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortedness(array4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortedness(array5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortedness(array6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortedness(array7)));

		System.out.println("\n*********************Node Sortedness Tester: Iterative");

		// this code uses the same values as the arrays above
		Node<Comparable> chain1 = new Node<Comparable>(1, new Node<Comparable>(2, new Node<Comparable>(3,
				new Node<Comparable>(3, new Node<Comparable>(5)))));
		Node<Comparable> chain2 = new Node<Comparable>(1, new Node<Comparable>(2, new Node<Comparable>(3,
				new Node<Comparable>(4, new Node<Comparable>(5, new Node<Comparable>(5))))));
		Node<Comparable> chain3 = new Node<Comparable>(10, new Node<Comparable>(8, new Node<Comparable>(5,
				new Node<Comparable>(3, new Node<Comparable>(1)))));
		Node<Comparable> chain4 = new Node<Comparable>(12, new Node<Comparable>(11, new Node<Comparable>(9,
				new Node<Comparable>(3, new Node<Comparable>(2, new Node<Comparable>(1))))));
		Node<Comparable> chain5 = new Node<Comparable>(2, new Node<Comparable>(8, new Node<Comparable>(3,
				new Node<Comparable>(9, new Node<Comparable>(6)))));
		Node<Comparable> chain6 = new Node<Comparable>(7, new Node<Comparable>(1, new Node<Comparable>(6,
				new Node<Comparable>(8, new Node<Comparable>(5, new Node<Comparable>(2))))));
		Node<Comparable> chain7 = new Node<Comparable>("abc",
				new Node<Comparable>("def", new Node<Comparable>("ghi")));

		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessIterative(chain3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessIterative(chain4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortednessIterative(chain5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortednessIterative(chain6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessIterative(chain7)));

		System.out.println("\n*********************Node Sortedness Tester: Recursive (Extra Credit Option)");
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain1)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain2)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessRecursive(chain3)));
		System.out.println("Sortedness \t0% \t" + formatter.format(sortednessRecursive(chain4)));
		System.out.println("Sortedness \t50% \t" + formatter.format(sortednessRecursive(chain5)));
		System.out.println("Sortedness \t40% \t" + formatter.format(sortednessRecursive(chain6)));
		System.out.println("Sortedness \t100% \t" + formatter.format(sortednessRecursive(chain7)));

	}

	public static double sortedness(Comparable[] array) {
		if (array.length <= 1) return 1;
		double unsortedCount = 0;
		for (int index = 0; index < array.length-1; index++) {
			Comparable first = array[index];
			Comparable second = array[index+1];
			if (first.compareTo(second) > 0) {
				unsortedCount++;
			}
		}
		double unsortedDec = unsortedCount/(array.length-1);
		return 1 - unsortedDec;
	}

	public static double sortednessIterative(Node<Comparable> node) {
		if (node == null || node.next == null) {
			return 1;
		}
		Node<Comparable> currentNode = node;
		double pairCount = 0;
		double unsortedCount = 0;
		while (currentNode.next != null) {
			pairCount++;
			if (currentNode.data.compareTo(currentNode.next.data) > 0) {
				unsortedCount++;
			}
			currentNode = currentNode.next;
		}
		double unsortedDec = unsortedCount / pairCount;
		return 1 - unsortedDec;
	}

	public static double sortednessRecursive(Node<Comparable> node) {
		if (node == null || node.next == null) {
			return 1;
		} else {
			return sortednessRecursiveHelper(node, node.next, 0, 0);
		}
	}

	private static double sortednessRecursiveHelper(Node<Comparable> node1, Node<Comparable> node2, double pairCount, double unsortedCount) {
		if (node2 == null) {
			return 1 - unsortedCount / pairCount;
		} else {
			boolean check = node1.data.compareTo(node2.data) > 0;
			return sortednessRecursiveHelper(node1.next, node2.next, pairCount + 1, check ? unsortedCount + 1 : unsortedCount);
		}
	}

}