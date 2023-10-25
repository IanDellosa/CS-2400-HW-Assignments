package Problem1;
import java.util.Arrays;

public class Bag<T> implements BagInterface<T>{
    private T[] bag;
    private int numOfEntries = 0;

    public Bag (int initialSize) {
        bag = (T[]) new Object[initialSize];
    }

    @Override
    public int getCurrentSize() {
        return numOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    public boolean isArrayFull() {
        return numOfEntries == bag.length;
    }

    @Override
    public void add(T newEntry) {
        if(isArrayFull()) {
            // make new array 2x size of current array
            doubleCapacity();
        }

        bag[numOfEntries] = newEntry;
        numOfEntries++;
    }

    private void doubleCapacity() {
        // Double capacity
        int newLength = bag.length * 2;

        // Create new array
        T[] newBag = (T[]) new Object[newLength];

        // Copy old array to new
        for (int i = 0; i < bag.length; ++i) {
            newBag[i] = bag[i];
        }

        // Change the reference
        bag = newBag;

        //Shortcut
        // bag = Arrays.copyOf(bag, newLength);
    }

    @Override
    public T remove() {
        T lastItem = bag[numOfEntries - 1];

        return remove(lastItem);
    }

    @Override
    public T remove(T anEntry) {
        if (getIndexOf(anEntry) < 0) {
            return null;
        }

        T temp = bag[getIndexOf(anEntry)];
        bag[getIndexOf(anEntry)] = bag[numOfEntries - 1];
        bag[numOfEntries - 1] = null;
        --numOfEntries;

        return temp;
    }

    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numOfEntries; ++i) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (int i = 0; i < numOfEntries; ++i) {
            if (anEntry.equals(bag[i])) {
                ++freq;
            }
        }
        return freq;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(this.bag, numOfEntries);
    }

}