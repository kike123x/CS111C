import java.util.*;

public class VoidRecursionExamples {

	public static void main(String[] args) {
		// printCharacters("Hello!");
		// printCharactersEfficient("Hello!");

		int[] numbers = {1, 2, 3, 4, 5, 6};
		// System.out.println(Arrays.toString(numbers));
		// doubleArray(numbers);
		// System.out.println(Arrays.toString(numbers));

		// List<Integer> list = new ArrayList<Integer>();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// System.out.println(list);
		// doubleList(list);
		// System.out.println(list);
		// printEveryOther(numbers);
		// System.out.println(isPalindrome("sameemas"));
		// System.out.println(isPalindrome("heleh"));
		// System.out.println(isPalindrome("h"));

		// System.out.println(methodA(4));
		// System.out.println(methodA(0));
		// System.out.println(methodA(-3));

		// System.out.println(methodB("eieio", 'e'));
		// System.out.println(methodB("hello there", 'h'));

		// System.out.println(countEvens(numbers));

		// int[] array = { 3, 4, 6, 7, 8, 10, 4 };
		// recMethod(array, 2, 5);
		int[] array = { 1, 4, 6, 3, 2, 7, 8 };
		recMethod(array, 3, 8);
	}

	public static void recMethod(int[] array, int start, int end) {

   if(start < end) {
      System.out.println(Arrays.toString(array));
			array[start] *= 2;
      recMethod(array, start+1, end);
			System.out.println(Arrays.toString(array));

   } else {
      System.out.println("done");
   }
}

	public static void printCharacters(String word) {
		/*
		if(word.length()==1) { // base case
			System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
		} else { // recursive case
			System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
			printCharacters(word.substring(1)); // recursively repeat the task with the rest of the word minus first character
		}
		*/
		System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
		if(word.length()>1) { // recursive case
			printCharacters(word.substring(1)); // recursively repeat the task with the rest of the word minus first character
		}
		// implicit base case- not explicitly listed
		System.out.println(word.charAt(0)); // word.substring(0,1); // prints the first character- solve a small part now
	}

	public static void printCharactersEfficient(String word) {
		printCharactersEfficientHelper(word, 0);
	}
	private static void printCharactersEfficientHelper(String word, int index) {
		System.out.println(word.charAt(index));
		if(index < word.length()-1 ) { // recursive call
			printCharactersEfficientHelper(word, index+1);
		}
	}

	public static void doubleArray(int[] array) {
		doubleArrayHelper(array, 0);
	}
	private static void doubleArrayHelper(int[] array, int index) {
		if(index<array.length) { // recursive call
			array[index] = array[index] * 2; // small part we're solving now
			doubleArrayHelper(array, index+1); // recursive call
		}
		// implicit base case
	}

	public static void doubleList(List<Integer> list) {
		doubleListHelper(list, 0);
	}
	private static void doubleListHelper(List<Integer> list, int index) {
		if(index<list.size()) { // recursive case
			int value = list.get(index);
			list.set(index, value*2);
			doubleListHelper(list, index+1);
		}
		// implicit base case
	}

	public static boolean isPalindrome(String word) {
		return isPalindromeHelper(word, 0);
	}

	private static boolean isPalindromeHelper(String word, int index) {
		if (word.charAt(index) == word.charAt(word.length()-1-index)) {
			if (index + 1 < word.length() / 2) {
				return isPalindromeHelper(word, index + 1);
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static int methodA(int n) {
		if (n == 0) {
			return 0;
		} else if (n > 0) {
			return 1 + methodA(n - 1);
		} else {
			return 1 + methodA(n + 1);
		}
	}

	// public static void printEveryOther(int[] nums, int index = 0) {
	// 	if (index < nums.length) {
	// 		System.out.println(nums[index]);
	// 		if (index + 2 < nums.length) {
	// 			printEveryOther(nums, index+2);
	// 		}
	// 	}
	// }

	public static int methodB(String s, char c) {
		if (s.length() == 0) {
			return 0;
		} else {
			return (s.charAt(0) == c ? 1 : 0) + methodB(s.substring(1), c);
		}
	}

	public static int countEvens(int[] array) {
		return countEvensHelper(array, 0, array.length);
	}

	private static int countEvensHelper(int[] array, int start, int stop) {
		int count = 0;
		if (start == stop) {
			return count;
		} else {
			if (array[start] % 2 == 0) {
				count = 1 + countEvensHelper(array, start + 1, stop);
			}
			return count;
		}
	}











}
