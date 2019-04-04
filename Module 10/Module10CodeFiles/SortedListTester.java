
public class SortedListTester {

	public static void main(String[] args) {
		// SortedListInterface<String> wordList = new SortedArrayList<>(); // or SortedLinkedList
		// wordList.add("delta");
		// wordList.display();
		// wordList.add("beta");
		// wordList.display();
		// wordList.add("alpha");
		// wordList.display();
		// wordList.add("gamma");
		// wordList.display();
		// wordList.add("beta");
		// wordList.display();

		// System.out.println("Removing position 4: " + wordList.remove(4));
		// wordList.display();
		// System.out.println("Remove of BETA successful?: " + wordList.remove("BETA"));
		// wordList.display();
		// System.out.println("Remove of beta successful?: " + wordList.remove("beta"));
		// wordList.display();
		// wordList.add("delta");
		// wordList.display();
		// int position = wordList.getPosition("delta");
		// System.out.println("delta is in position " + position);
		// position = wordList.getPosition("epsilon");
		// System.out.println("epsilon is in position " + position);

		// SortedListInterface<String> sortedList = new SortedArrayList<>();
		// sortedList.add("ponies");
		// sortedList.add("apples");
		// sortedList.add("fruit");
		// sortedList.add("bananas");
		// sortedList.add("dogs");
		// sortedList.display();
		// sortedList.add("ponies");
		// sortedList.add("apples");
		// sortedList.add("fruit");
		// sortedList.add("bananas");
		// sortedList.add("dogs");
		// System.out.println(sortedList.getLength());

		SortedListInterface<Integer> sortedList = new SortedArrayList<>();
		// sortedList.add(59);
		// sortedList.add(14);
		// sortedList.add(46);
		// sortedList.add(22);
		// sortedList.add(35);
		// System.out.println(sortedList.getPosition(22));
		// sortedList.add(59);
		// sortedList.add(14);
		// sortedList.add(46);
		// sortedList.add(22);
		// sortedList.add(35);
		// System.out.println(sortedList.getPosition(50));
		sortedList.add(59);
		sortedList.add(14);
		sortedList.add(46);
		sortedList.add(22);
		sortedList.add(35);
		sortedList.remove(Integer.valueOf(22));  // the remove(T) method

		System.out.println(sortedList.getPosition(59));
		System.out.println(sortedList.getPosition(14));
		System.out.println(sortedList.getPosition(46));
		System.out.println(sortedList.getPosition(22));
		System.out.println(sortedList.getPosition(35));
	}

}
