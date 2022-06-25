package java.bag;

import java.util.Arrays;

public class ResizeableArrayBag<T> extends ArrayBag<T> {
	public ResizeableArrayBag() {
		this(DEFAULT_CAPACITY); // calls the more specific constructor
	}

	public ResizeableArrayBag(int capacity) {
		super(capacity);
	}

	@Override
	public boolean add(T newEntry) {
		this.checkIntegrity();

		if (this.isFull())
			this.resize();

		bag[this.numberOfEntries] = newEntry;
		this.numberOfEntries++;

		return true;
	}

	private void resize() {

		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		this.bag = Arrays.copyOf(bag, newLength);
	}

	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose " +
					"capacity exeeds allowed " +
					"maximum of " + MAX_CAPACITY);
	}
}