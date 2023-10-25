package Problem2;

/**
 * A class that implements the ADT double-ended list by using a chain of nodes.
 * The chain has both a head reference and a tail reference.
 * Position numbers begin with 1.
 * 
 * @author Frank M. Carrano
 * @author Joseph Erickson
 * @version 5.0
 */
public class DoubleEndedList<T> implements ListInterface<T>, DoubleEndedInterface<T> {
	private Node firstNode; // Head reference to first node
	private Node lastNode; // Tail reference to last node
	private int numberOfEntries;

	public DoubleEndedList() {
		clear();
	}

	// =========================================================================
	// ADDED METHODS:
	public void addFirst(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
	} // end addFirst

	public void addLast(T newEntry) {
		Node newNode= new Node(newEntry);
		Node last = firstNode;
		if (isEmpty()) {
			addFirst(newEntry);
		} else {
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
			lastNode = newNode;
			numberOfEntries++;
		}
	} // end addLast

	public T removeFirst() {
		if (!isEmpty()) {
			T temp = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			return temp;
		} else {
			return null;
		}
	} // end removeFirst

	public T removeLast() {
		T temp = null;
		Node a = firstNode;
		Node b = firstNode;

		if (!isEmpty()) {
			while (a.next != null) {
				b = a;
				a = a.next;
			}
			temp = a.data;
			b.next = null;
			lastNode = b;
			--numberOfEntries;
			return temp;
		} else {
			return null;
		}
//		Node prev = firstNode;
//		if (!isEmpty()) {
//			while (prev.next != lastNode) {
//				prev = prev.next;
//			}
//			prev.next = null;
//			lastNode = prev;
//			--numberOfEntries;
//			return temp;
//		} else {
//			return null;
//		}
	} // end removeLast

	public T getFirst() {
		return firstNode.data;
	} // end getFirst

	public T getLast() {
		Node a = firstNode;
		while (a.next != null) {
			a = a.next;
		}
		return a.data;
	} // end getLast

	public void moveToEnd() {
		addLast(firstNode.data);
		removeFirst();
//		lastNode.next = firstNode;
//		lastNode = lastNode.next;
//		firstNode = firstNode.next;
	} // end moveToEnd

	// =========================================================================
	public final void clear() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	} // end clear

	public void add(T newEntry) {
		Node newNode = new Node(newEntry); // Create new node

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);

		lastNode = newNode;
		numberOfEntries++;
	} // end add

	public void add(int newPosition, T newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			Node newNode = new Node(newEntry);

			if (isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} // end if
			else if (newPosition == 1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} // end else if
			else if (newPosition == numberOfEntries + 1) {
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			} // end else if
			else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} // end else
			numberOfEntries++;
		} // end if
		else
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
	} // end add

	public T remove(int givenPosition) {
		T result = null; // Return value

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			if (givenPosition == 1) // Case 1: Remove first entry
			{
				result = firstNode.getData(); // Save entry to be removed
				firstNode = firstNode.getNextNode();
				if (numberOfEntries == 1)
					lastNode = null; // Solitary entry was removed
			} // end if
			else // Case 2: givenPosition > 1
			{
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter); // Disconnect the node to be removed
				result = nodeToRemove.getData(); // Save entry to be removed

				if (givenPosition == numberOfEntries)
					lastNode = nodeBefore; // Last node was removed
			} // end else

			numberOfEntries--;
		} // end if
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");

		return result; // Return removed entry
	} // end remove

	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty

			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		} // end if
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	} // end replace

	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			// Assertion: The list is not empty
			return getNodeAt(givenPosition).getData();
		} // end if
		else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	} // end getEntry

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while

		return found;
	} // end contains

	public int getLength() {
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while

		return result;
	} // end toArray

	// Returns a reference to the node at a given position.
	// Precondition: List is not empty; 1 <= givenPosition <= numberOfEntries.
	private Node getNodeAt(int givenPosition) {
		// Assertion: (firstNode != null) and (1 <= givenPosition) and (givenPosition <=
		// numberOfEntries)
		Node currentNode = firstNode;

		if (givenPosition == numberOfEntries)
			currentNode = lastNode;
		else if (givenPosition > 1) // Traverse the chain to locate the desired node
		{
			for (int counter = 1; counter < givenPosition; counter++)
				currentNode = currentNode.getNextNode();
		} // end else if

		assert currentNode != null;
		return currentNode;
	} // end getNodeAt

	private class Node {
		private T data; // Data portion
		private Node next; // Next to next node

		private Node(T dataPortion)// PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(T dataPortion, Node nextNode)// PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end DoubleEndedList
