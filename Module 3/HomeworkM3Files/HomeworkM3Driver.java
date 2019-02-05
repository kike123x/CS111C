import java.util.*;

public class HomeworkM3Driver {

	public static void main(String[] args) {

		BagInterface<String> wordBag = new ArrayBag<>();
		wordBag.add("apple");
		wordBag.add("dog");
		wordBag.add("cat");
		wordBag.add("banana");
		System.out.println(wordBag.remove());

		// ListInterface<String> wordList = new AList<>();

		// List<String> wordList = new ArrayList<>();



		// System.out.println("******TESTING QUESTION 39: TESTING IF BAG IS A SET");
		// BagInterface<String> wordBag = new ArrayBag<>();
		// System.out.println("Bag is set? true: " + isSet(wordBag));
		// System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[]");
		// System.out.println(Arrays.toString(wordBag.toArray()));
		// wordBag.add("hi");
		// System.out.println("Bag is set? true: " + isSet(wordBag));
		// System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[hi]");
		// System.out.println(Arrays.toString(wordBag.toArray()));
		// wordBag.add("HI");
		// wordBag.add("hello");
		// System.out.println("Bag is set? true: " + isSet(wordBag));
		// System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[hi, HI, hello]");
		// System.out.println(Arrays.toString(wordBag.toArray()));
		// wordBag.add("hi");
		// System.out.println("Bag is set? false: " + isSet(wordBag));
		// System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[hi, HI, hello, hi]");
		// System.out.println(Arrays.toString(wordBag.toArray()));


		// System.out.println("\n******TESTING QUESTION 41: CREATING SHORT STRING LIST");
		// ListInterface<String> wordList = new AList<>();
		// wordList.add("ape");
		// wordList.add("dog");
		// wordList.add("cockroach");
		// wordList.add("baboon");
		// wordList.add("frog");
		// wordList.add("spider");
		// wordList.add("cat");
		// ListInterface<String> shortWordList = createShortWordList(wordList,4);
		// System.out.println("The contents of the list should be (in THIS ORDER): \n[ape, dog, cat]");
		// System.out.println(Arrays.toString(shortWordList.toArray()));

		// System.out.println("\n******TESTING QUESTION 42: FINDING LAST POSITION");
		// List<String> itemList = new ArrayList<>();
		// itemList.add("adam");
		// itemList.add("frank");
		// itemList.add("betty");
		// itemList.add("sue");
		// itemList.add("sam");
		// itemList.add("frank");
		// itemList.add("sue");
		// itemList.add("terry");
		// itemList.add("adam");
		// itemList.add("frank");
		// System.out.println("The index should be: \n9\n" + lastPosition(itemList, "adam"));

		// System.out.println("\n******TESTING QUESTION 43: LIST COMPARISON");
		// List<Integer> numList1 = new ArrayList<Integer>();
		// numList1.add(1);
		// numList1.add(3);
		// numList1.add(1);
		// numList1.add(5);
		// numList1.add(7);
		// ListInterface<Integer> numList2 = new AList<Integer>();
		// System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numList1, numList2));
		// numList2.add(1);
		// System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numList1, numList2));
		// numList2.add(3);
		// numList2.add(1);
		// numList2.add(5);
		// System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numList1, numList2));
		// numList2.add(7);
		// System.out.println("Equivalent should be: \ntrue\n" + equivalentLists(numList1, numList2));
		// numList2.add(8);
		// System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numList1, numList2));
		// numList1.add(8);
		// numList1.add(10);
		// System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numList1, numList2));


		// System.out.println("\n******TESTING EXTRA CREDIT QUESTION 44: MOVE THE MINIMUM TO THE FRONT");
		// List<Integer> numberList = new ArrayList<Integer>();
		// prioritizeMinimumValue(numberList);
		// System.out.println("The list should contain: \n[]\n" + numberList);
		// numberList.add(4);
		// prioritizeMinimumValue(numberList);
		// System.out.println("The list should contain: \n[4]\n" + numberList);
		// numberList.add(3);
		// numberList.add(1);
		// numberList.add(5);
		// numberList.add(7);
		// prioritizeMinimumValue(numberList);
		// System.out.println("The list should contain: \n[1, 4, 3, 5, 7]\n" + numberList);
		// numberList.add(0);
		// prioritizeMinimumValue(numberList);
		// System.out.println("The list should contain: \n[0, 1, 4, 3, 5, 7]\n" + numberList);


	}

	public static boolean isSet(BagInterface<String> wordBag) {
		if (!wordBag.isEmpty() || wordBag.getCurrentSize() > 1) {
			BagInterface<String> tempBag = new ArrayBag<>();

			boolean check = true;
			while (wordBag.getCurrentSize() > 0) {
				String temp = wordBag.remove();
				if (wordBag.getFrequencyOf(temp) > 0) {
					check = false;
				}
				tempBag.add(temp);
			}

			// putting items back into original bag
			while(tempBag.getCurrentSize() > 0) {
				String tempStr = tempBag.remove();
				wordBag.add(tempStr);
			}

			return check;
		} else {
			return true;
		}
	}

	public static ListInterface<String> createShortWordList(ListInterface<String> wordList, int length) {
		ListInterface<String> newList = new AList<>();

		for (int i = 1; i <= wordList.getLength(); i++) {
			if (wordList.getEntry(i).length() < length) {
				newList.add(wordList.getEntry(i));
			}
		}

		return newList;
	}

	public static int lastPosition(List<String> wordList, String targetWord) {
		for (int i = wordList.size() - 1; i >= 0; i--) {
			if (wordList.get(i).equals(targetWord)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean equivalentLists(List<Integer> numberList, ListInterface<Integer> numberListInterface) {
		if (numberList.size() == numberListInterface.getLength()) {
			for (int i = 0; i < numberList.size(); i++) {
				if (numberList.get(i) != numberListInterface.getEntry(i+1)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void prioritizeMinimumValue(List<Integer> numberList) {
		if (numberList.size() > 1) {
			int smallestIndex = 0;
			for (int i = 1; i < numberList.size(); i++) {
				if (numberList.get(i) < numberList.get(smallestIndex)) {
					smallestIndex = i;
				}
			}

			if (smallestIndex > 0) {
				Integer temp = numberList.remove(smallestIndex);
				numberList.add(0, temp);
			}
		}
	}
}
