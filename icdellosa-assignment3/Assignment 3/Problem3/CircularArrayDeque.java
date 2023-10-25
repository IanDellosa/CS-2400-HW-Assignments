package Problem3;

public class CircularArrayDeque<T> implements DequeInterface<T>{
    T[] arrayDeque = (T[]) new Object[10];
    int frontPointer = 0;
    int endPointer = arrayDeque.length - 1;


    @Override
    public void addToFront(T newEntry) {
        System.out.println("Adding " + newEntry.toString() + " to front.");
        if(isFull()) {
            doubleCapacity();
        }

        if (frontPointer == 0) {
            frontPointer = arrayDeque.length - 1;
        } else {
            frontPointer = (frontPointer - 1) % arrayDeque.length;
        }
        arrayDeque[frontPointer] = newEntry;
    }

    @Override
    public void addToBack(T newEntry) {
        System.out.println("Adding " + newEntry.toString() + " to back.");
        if(isFull()) {
            doubleCapacity();
        }
        endPointer = (endPointer + 1) % arrayDeque.length;
        arrayDeque[endPointer] = newEntry;
    }

    private void doubleCapacity() {
        T[] oldQueue = arrayDeque;
        int newSize = arrayDeque.length * 2;
        arrayDeque = (T[]) new Object[newSize];
        for(int i = 0; i < oldQueue.length; ++i) {
            arrayDeque[i] = oldQueue[frontPointer];
            frontPointer = (frontPointer + 1) % oldQueue.length;
        }
        frontPointer = 0;
        endPointer = oldQueue.length - 1;
    }

    @Override
    public T removeFront() {
        T temp;
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        temp = arrayDeque[frontPointer];
        arrayDeque[frontPointer] = null;
        frontPointer = (frontPointer + 1) % arrayDeque.length;
        return temp;
    }

    @Override
    public T removeBack() {
        T temp;
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        temp = arrayDeque[endPointer];
        arrayDeque[endPointer] = null;
        if (endPointer == 0) {
            endPointer = arrayDeque.length - 1;
        } else {
            endPointer = (endPointer - 1) % arrayDeque.length;
        }
        return temp;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return arrayDeque[frontPointer];
    }

    @Override
    public T getBack() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        return arrayDeque[endPointer];
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return frontPointer == (endPointer + 1) % arrayDeque.length;
    }

    public boolean isFull() {
        return frontPointer == (endPointer + 2) % arrayDeque.length;
    }

    @Override
    public void clear() {
        while(!isEmpty()) {
            removeBack();
        }
    }
}
