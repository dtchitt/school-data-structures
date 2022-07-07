package javaDataStructures.bag;

import javaDataStructures.common.Node;

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

		this.firstNode = newNode;
		this.numberOfEntries++;

		return true;
	}

	@Override
	public T remove() {
		T result = null;

		if (this.firstNode != null) {
			result = this.firstNode.getData();
			this.firstNode = this.firstNode.getNextNode();
			this.numberOfEntries--;
		}

		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> nodeN = getReferenceTo(anEntry);

		if (nodeN != null) {
			nodeN.setData(this.firstNode.getData());
			this.firstNode = this.firstNode.getNextNode();
			this.numberOfEntries--;
			result = true;
		}

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
		int frequency = 0;
		int counter = 0;
		Node<T> currNode = this.firstNode;

		while ((counter < this.numberOfEntries) && currNode != null) {
			if (anEntry.equals(currNode.getData())) {
				frequency++;
			}

			counter++;
			currNode = currNode.getNextNode();
		}

		return frequency;
	}

	@Override
	public boolean cotains(T anEntry) {
		boolean found = false;
		Node<T> curNode = this.firstNode;

		while (!found && curNode != null) {
			if (anEntry.equals(curNode.getData())) {
				found = true;
			} else {
				curNode = curNode.getNextNode();
			}
		}
		
		return found;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[this.numberOfEntries];

		int index = 0;
		Node<T> curNode = this.firstNode;

		while (index < this.numberOfEntries && curNode != null) {
			result[index] = curNode.getData();
			index++;
			curNode = curNode.getNextNode();
		}

		return result;
	}

	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = this.firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}

		return currentNode;
	}
}
