package javaDataStructures.bag;

import java.util.Arrays;

public class Bags {
	/**
	 * Test the ArrayBag methods
	 */
	public static void ArrayBagTest() {
		//Partial Fill test
		System.out.println();

		BagInterface<String> bag = new ArrayBag<>();
		String[] testContents = { "A", "A", "B", "A", "C", "A" };

		System.out.println("Testing an initially empty bag with sufficient capcity.");
		System.out.println("String to be added to bag: " + Arrays.toString(testContents));

		Bags.testAdd(bag, testContents);
		Bags.testToArray(bag);

		//Filled test
		System.out.println();

		System.out.println("Testing an initially empty bag that will be filled to capacity: ");
		BagInterface<String> bag2 = new ArrayBag<>(7);
		String[] testContents2 = { "A", "A", "B", "A", "C", "A", "another string" };

		Bags.testAdd(bag2, testContents2);
		Bags.testToArray(bag2);

		//Overfill test
		System.out.println();

		System.out.println("Testing an initially empty bag that will be overfilled: ");
		BagInterface<String> bag3 = new ArrayBag<>(6);
		String[] testContents3 = { "A", "A", "B", "A", "C", "A", "another string" };

		Bags.testAdd(bag3, testContents3);
		Bags.testToArray(bag3);
	}

	public static void ResizeableArrayBagTest() {

	}

	public static void LinkedBagTest() {

	}

	/**
	 * Test the add method for a bag
	 * 
	 * @param bag     to test
	 * @param content of bag
	 */
	private static void testAdd(BagInterface<String> bag, String[] content) {
		System.out.print("Adding ");

		for (int i = 0; i < content.length; i++) {

			if (bag.add(content[i])) {
				System.out.print(" " + content[i] + ", ");
			} else {
				System.out.println();
				System.out.print("Unable to add " + content[i]);
			}
		}

		System.out.println(" to the bag");
	}

	/**
	 * Test the toArray method for a bag
	 * 
	 * @param bag to test
	 */
	private static void testToArray(BagInterface<String> bag) {
		System.out.print("The bag contains the following string(s): ");
		System.out.println(Arrays.toString(bag.toArray()));
	}
}
