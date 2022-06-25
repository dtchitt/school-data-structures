package java.bag;

import java.common.Node;

public class LinkedChainBag<T> implements BagInterface<T> {
	private Node<T> firstNode;
	private int numberOfEntries;

	public LinkedChainBag() {
		this.firstNode = null;
		this.numberOfEntries = 0;
	}

	public LinkedChainBag(Node<T> data, int size) {
		this.firstNode = data;
		this.numberOfEntries = size;
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
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNextNode(this.firstNode);

		return false;
	}

	@Override
	public T remove() {
		T result = null;

		if (firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
		}

		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> nodeN = getReferenceTo(anEntry);
		if (nodeN != null) {
			// Replace located entry with entry in first node
			nodeN.setData(firstNode.getData());
			// Remove first node
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
			result = true;
		} // end if
		return result;

	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean cotains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}

		return currentNode;
	}
}
