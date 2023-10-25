package Problem2;

public class LinkedBag<T> implements BagInterface<T>{
    private Node firstNode;
    private int numOfEntries;

    public LinkedBag() {
        firstNode = null;
        numOfEntries = 0;
    }
    public class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node (T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }

    }

    @Override
    public int getCurrentSize() {
        Node currentNode = firstNode;
        int i = 0;
        int counter = 0;
        while (i < numOfEntries && currentNode != null) {
            ++counter;
            ++i;
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numOfEntries++;
        return true;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && currentNode != null) {
            if(anEntry.equals(currentNode.data)) {
                found = true;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    private int getNodeNumber (T anEntry) {
        int counter = 1;
        Node currentNode = firstNode;

        while (counter > numOfEntries && currentNode != null) {
            if(anEntry.equals(currentNode.data)) {
                break;
            }
            else {
                ++counter;
            }
        }

        return counter;
    }
    @Override
    public T remove() {
        T result = null;

        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next;
            numOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        Node a = firstNode;
        Node b = firstNode;
        boolean removed = false;

        while (a != null && a != getReferenceTo(anEntry)) {
            b = a;
            a = a.next;
        }

        if (a != null && a == getReferenceTo(anEntry)) {
            if (a == firstNode) {
                remove();
            }
            else {
                b.next = a.next;
                removed = true;
                --numOfEntries;
            }
        }

        return removed;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
        numOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;

        while ((loopCounter < numOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                freq++;
            }

            loopCounter++;
            currentNode = currentNode.next;
        }
        return freq;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numOfEntries];

        int i = 0;
        Node currentNode = firstNode;
        while ((i < numOfEntries) && (currentNode != null)) {
            result[i] = currentNode.data;
            ++i;
            currentNode = currentNode.next;
        }
        return result;
    }
}