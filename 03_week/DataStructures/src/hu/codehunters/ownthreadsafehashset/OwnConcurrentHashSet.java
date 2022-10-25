package hu.codehunters.ownthreadsafehashset;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class OwnConcurrentHashSet<T> {

	private final LinkedList[] data = new LinkedList[5];
	private volatile AtomicBoolean onProcess = new AtomicBoolean();

	public OwnConcurrentHashSet() {
		for (int i = 0; i < data.length; i++) {
			data[i] = new LinkedList<T>();
		}
	}

	public boolean add(T item) {
		int index = getIndex(item);
		if (!onProcess.get()) {
			synchronized (data[index]) {
				return data[index].add(item);
			}
		}
		return false;
	}

	public void print() {
		synchronized (data) {
			onProcess.set(true);
			Arrays.stream(data)
					.filter(Objects::nonNull)
					.forEach(linkedList -> linkedList.forEach(System.out::println));
			onProcess.set(false);
		}
	}

	public boolean contains(T item) {
		if (!onProcess.get()) {
			int index = getIndex(item);
			synchronized (data[index]) {
				Optional foundItem = data[index].stream()
						.filter(element -> element.equals(item))
						.findFirst();
				return foundItem.isPresent();
			}
		}
		return false;
	}

	private int getIndex(T item) {
		return item.hashCode() & (data.length - 1);
	}

}
