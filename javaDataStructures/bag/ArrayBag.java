package javaDataStructures.bag;

public class ArrayBag<T> implements BagInterface<T> {
	protected T[] bag;
	protected int numberOfEntries;
	protected boolean integrity;

	protected static final int DEFAULT_CAPACITY = 25;
	protected static final int MAX_CAPACITY = 10000;

	public ArrayBag() {
		this(DEFAULT_CAPACITY); // calls the more specific constructor
	}

	public ArrayBag(int capacity) {
		this.integrity = false;

		if (capacity <= MAX_CAPACITY) {
			// When creating array based DS we must use the following syntax for
			// this.arrayType creation.
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[]) new Object[capacity];
			bag = tempBag;
			numberOfEntries = 0;
			this.integrity = true;
		} else {
			throw new IllegalStateException(
					"Attempt to create a bag whose capacity exceeds allowed maximum.");
		}
	}

	@Override
	public int getCurrentSize() {
		return this.numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return this.numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		this.checkIntegrity();

		if (this.isFull())
			return false;

		bag[this.numberOfEntries] = newEntry;
		this.numberOfEntries++;

		return true;
	}

	@Override
	public T remove() {
		this.checkIntegrity();

		return removeEntry(numberOfEntries - 1);
	}

	@Override
	public boolean remove(T anEntry) {
		this.checkIntegrity();

		int i = this.getIndexOf(anEntry);
		T result = this.removeEntry(i);
		return anEntry.equals(result);
	}

	@Override
	public void clear() {
		while (!this.isEmpty()) {
			remove();
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		checkIntegrity();

		int counter = 0;

		for (int i = 0; i < this.numberOfEntries; i++) {
			if (anEntry.equals(bag[i]))
				counter++;
		}

		return counter;
	}

	@Override
	public boolean cotains(T anEntry) {
		checkIntegrity();
		return getIndexOf(anEntry) > -1;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[this.numberOfEntries];

		for (int i = 0; i < this.numberOfEntries; i++) {
			result[i] = bag[i];
		}

		return result;
	}

	protected boolean isFull() {
		return this.numberOfEntries == this.bag.length;
	}

	protected void checkIntegrity() {
		if (!this.integrity)
			throw new SecurityException("ArrayBag Object is Corrupt.");
	}

	protected int getIndexOf(T anEntry) {
		int where = -1;

		for (int i = 0; i < this.numberOfEntries; i++) {
			if (anEntry.equals(bag[i])) {
				where = i;
				break;
			}
		}

		return where;
	}

	protected T removeEntry(int index) {
		T result = null;

		if (!isEmpty() && index >= 0) {
			result = bag[index]; // Entry to remove
			bag[index] = bag[this.numberOfEntries - 1]; // Replace entry with last entry
			bag[this.numberOfEntries - 1] = null; // Remove last entry
			this.numberOfEntries--;
		}

		return result;
	}
}