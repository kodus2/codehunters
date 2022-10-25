package hu.codehunters;

import hu.codehunters.ownlinkedlist.OwnLinkedList;
import hu.codehunters.ownthreadsafehashset.OwnConcurrentHashSet;

import java.util.NoSuchElementException;

public class Main {

	private static final String APPLE = "alma";
	private static final String PEAR = "körte";
	private static final String ORANGE = "narancs";
	private static final String BANANA = "banán";
	private static final String CHERRY = "meggy";
	private static final String PEACH = "barack";

	public static void main(String[] args) {
		//        new Main().runOwnLinkedList();
		new Main().runOwnConcurrentHashMap();
	}

	private void runOwnLinkedList() {
		OwnLinkedList<String> list = new OwnLinkedList<>();
		list.add(APPLE);
		list.add(PEAR);
		list.add(ORANGE);
		list.add(BANANA);
		list.add(CHERRY);
		list.print();
		printIndexOfTheElement(list, ORANGE);
		printIndexOfTheElement(list, "kis kutya");
		printIndexOfTheElement(list, APPLE);
	}

	private void runOwnConcurrentHashMap() {
		OwnConcurrentHashSet<String> hashSet = new OwnConcurrentHashSet<>();
//		hashSet.add(APPLE);
//		hashSet.add(PEAR);
//		hashSet.add(ORANGE);
//		hashSet.add(BANANA);
//		hashSet.add(CHERRY);
//		hashSet.add(PEACH);
//		hashSet.print();
//		printItemIsFound(hashSet, APPLE);
//		printItemIsFound(hashSet, "kis kutya");

	}

	private <E> void printItemIsFound(OwnConcurrentHashSet<E> hashSet, E searchedElement) {
		System.out.printf("'%s' is%s contained\n", searchedElement, hashSet.contains(searchedElement) ? "" : " not");
	}

	private <E> void printIndexOfTheElement(OwnLinkedList<E> list, E searchedElement) {
		try {
			System.out.printf("Index of the element '%s': %d\n", searchedElement, list.find(searchedElement));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

}
