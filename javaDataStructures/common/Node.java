package javaDataStructures.common;

/**
 * Node - Used for linked chain data structures.
 * This will produce a singly linked chain
 */
public class Node<T> {
	private T data;
	private Node<T> next;

	public Node(T data) {
		this(data, null);
	}

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T newData) {
		this.data = newData;
	}

	public Node<T> getNextNode() {
		return this.next;
	}

	public void setNextNode(Node<T> next) {
		this.next = next;
	}
}