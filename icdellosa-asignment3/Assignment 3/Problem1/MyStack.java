package Problem1;

import java.util.EmptyStackException;

public class MyStack<T> implements StackInterface<T>{

    private class Node {
        public T data;
        public Node next;
        public Node(T data) {
            this(data, null);
        }
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node topNode;

    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T temp;
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            temp = peek();
            topNode = topNode.next;
        }
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topNode.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }
}
