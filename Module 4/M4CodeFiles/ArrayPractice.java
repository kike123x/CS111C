import java.util.Arrays;

public class ArrayPractice {

	public static void main(String[] args) {
		// int[] numbers = {0, 0, 0, 0, 0};

		// System.out.println("in main before:\t" + Arrays.toString(numbers));
		// changeArrayCorrect(numbers);
		// //changeArrayIncorrect1(numbers);
		// //changeArrayIncorrect2(numbers);
		// System.out.println("in main after:\t" + Arrays.toString(numbers));

		// ListInterface<Integer> listNum = new AList();
		ArrayBag<Integer> listNum = new ArrayBag<>();
		// 8, 9, 6, 3, 8, 6, 1)
		System.out.println(listNum.getAnEntry());
		listNum.add(8);
		listNum.add(9);
		listNum.add(6);
		listNum.add(3);
		listNum.add(8);
		listNum.add(6);
		listNum.add(1);
		listNum.add(0);
		// System.out.println(recursiveCountMultiples(listNum, -3));
		// System.out.println(recursiveCountMultiples(listNum, 6));
		// System.out.println(recursiveCountMultiples(listNum, 12));
		System.out.println(listNum.getAnEntry());
		System.out.println(listNum.getAnEntry());
		System.out.println(listNum.getAnEntry());
		System.out.println(listNum.getAnEntry());
	}

	// midterm exam
	public static int recursiveCountMultiples(ListInterface<Integer> list, int number) {
		if (number == 0) {
			throw new ArithmeticException("Cannot divide by 0");
		}
		int count = 0;
		int index = 1;
		while (index <= list.getLength()) {
			Integer num = list.getEntry(index);
			if (num % number == 0) {
				count++;
			}
			index++;
		}
		return count;
	}

	public static void changeArrayCorrect(int[] numberArray) {
		// the formal parameter numberArray and the actual parameter sent in are aliases- they are the same object
		// changes made inside the method affect the object outside the method
		for(int i=0; i<numberArray.length; i++) {
			numberArray[i]++;
		}
	}

	public static void changeArrayIncorrect1(int[] numberArray) {
		for(int num : numberArray) { // cannot use a for-each to update the value of an array
			num++;
		}
	}




	public static void changeArrayIncorrect2(int[] numberArray) {
		int[] numbersModified = new int[numberArray.length];
		for(int i=0; i<numberArray.length; i++) {
			numbersModified[i] = numberArray[i] + 1;
		}
		numberArray = numbersModified; // the formal parameter now points to a new place in memory
		// the alias link is broken- so the numberArray is changed, but the actual parameter is not

		System.out.println("in method:\t" + Arrays.toString(numberArray));
	}

}
