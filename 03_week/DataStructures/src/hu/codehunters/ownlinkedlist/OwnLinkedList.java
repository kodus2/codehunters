package hu.codehunters.ownlinkedlist;

import java.util.NoSuchElementException;

public class OwnLinkedList<E> {

	transient int size;
	transient Node<E> head;
	transient Node<E> tail;

	public boolean add(E data) {
		Node<E> last = tail;
		Node<E> newNode = new Node<>(last, data, null);
		tail = newNode;
		if (last == null) {
			head = newNode;
		} else {
			last.next = newNode;
		}
		size++;
		return true;
	}

	public void print() {
		System.out.println("Elements of the list: " + iterateToPrint(head, new StringBuilder()));
	}

	public int find(E data) {
		return iterateToFind(head, data, 0);
	}

	private String iterateToPrint(Node<E> node, StringBuilder sb) {
		sb.append(node.data.toString());
		if (hasNext(node)) {
			sb.append(", ");
			iterateToPrint(node.next, sb);
		}
		return sb.toString();
	}

	private int iterateToFind(Node<E> node, E data, int index) {
		if (node.data.equals(data)) {
			return index;
		} else if (hasNext(node)) {
			return iterateToFind(node.next, data, ++index);
		} else {
			throw new NoSuchElementException("There is no " + data.toString());
		}
	}

	private boolean hasNext(Node node) {
		return node.next != null;
	}

	private static class Node<E> {
		E data;
		Node<E> next;
		Node<E> previous;

		Node(Node<E> previous, E data, Node<E> next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}
}
