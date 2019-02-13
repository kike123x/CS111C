import java.util.Arrays;

public class ArrayBagTester {

	public static void main(String[] args) {

		// BagInterface<Integer> numberBag = new ArrayBag<>();

		// numberBag.add(1);
		// numberBag.add(2);
		// numberBag.add(3);

		// // /*
		// // if(numberBag instanceof ArrayBag<?>)
		// // 	System.out.println( ((ArrayBag<Integer>)numberBag).removeRandom() );
		// //  */

		// BagInterface<Integer> numberBag2 = new ArrayBag<>();
		// numberBag2.add(3);
		// numberBag2.add(2);
		// numberBag2.add(1);
		// numberBag2.add(4);

		// System.out.println(numberBag.equals(numberBag2));

		// BagInterface<String> wordBag = new ArrayBag<>();
		// wordBag.add("apple");
		// wordBag.add("banana");
		// wordBag.add("pear");

		// System.out.println(numberBag.equals(wordBag));


		// ArrayBag<String> animalBag = new ArrayBag<String>();
		// animalBag.add("a");
		// animalBag.add("b");
		// animalBag.add("c");
		// animalBag.add("d");
		// animalBag.add("e");
		// animalBag.add("f");
		// System.out.println(animalBag.getCurrentSize());
		// System.out.println(animalBag.getAllLessThan("e").getCurrentSize());

		// ListInterface<String> strList = new AList<>();
		// strList.add("a");
		// strList.add("c");
		// strList.add("e");
		// System.out.println(((AList<String>)strList).getAllLessThan("d").getLength()); // 2

		// AList<Integer> numList = new AList<>();
		// numList.add(1);
		// numList.add(2);
		// numList.add(3);
		// System.out.println(numList.getAllLessThan(2).getLength()); // 1

		ListInterface<String> strList = new AList<>();

		strList.add("a");

		strList.add("c");

		strList.add("e");

		System.out.println(strList.getAllLessThan("d").getLength());

	}

}
