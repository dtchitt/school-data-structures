package javaDataStructures.bag;

import javaDataStructures.common.Node;

public class LinkedChainBag<T> implements BagInterface<T> {
	private Node<T> firstNode;
	private int size;

	public LinkedChainBag() {
		this.firstNode = null;
		this.size = 0;
	}

	public LinkedChainBag(Node<T> data, int size) {
		this.firstNode = data;
		this.size = size;
	}

	@Override
	public int getCurrentSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.firstNode == null;
	}

	@Override
	public boolean add(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNextNode(this.firstNode);

		this.firstNode = newNode;
		this.size++;

		return true;
	}

	@Override
	public T remove() {
		T result = null;

		if (this.firstNode != null) {
			result = this.firstNode.getData();
			this.firstNode = this.firstNode.getNextNode();
			this.size--;
		}

		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		Node<T> nodeN = getReferenceTo(anEntry);

		if (nodeN != null) {
			nodeN.setData(firstNode.getData());
			firstNode = firstNode.getNextNode();
			this.size--;
			return true;
		}

		return false;
	}

	@Override
	public void clear() {
		this.firstNode = null;
		this.size = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int counter = 0;
		Node<T> currNode = this.firstNode;

		while ((counter < this.size) && currNode != null) {
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
		return this.getReferenceTo(anEntry) == null ? false : true;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[this.size];

		int index = 0;
		Node<T> curNode = this.firstNode;

		while (index < this.size && curNode != null) {
			result[index] = curNode.getData();
			index++;
			curNode = curNode.getNextNode();
		}

		return result;
	}

	private Node<T> getReferenceTo(T anEntry) {
		Node<T> currentNode = this.firstNode;

		while (!anEntry.equals(currentNode.getData()) && currentNode != null) {
			currentNode = currentNode.getNextNode();
		}

		return currentNode;
	}
}
