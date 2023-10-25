package Problem1    ;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AList<T> implements ListInterface<T>{
    private T[] L = (T[]) new Object[10];
//    ArrayList<T> list = new ArrayList<>();
    private int numOfEntries = 0;
    @Override
    public void add(T newEntry) {
//        list.add(newEntry);
        L[numOfEntries] = newEntry;
        ++numOfEntries;
    }

    @Override
    public void add(int newPosition, T newEntry) {
        if (newPosition >= -1 && newPosition <= numOfEntries + 1) {
//            list.add(newPosition, newEntry);
            makeRoom(newPosition);
            L[newPosition] = newEntry;
            ++numOfEntries;
        }
    }

    private void makeRoom (int givenPosition) {
        for(int i = numOfEntries - 1; i >= givenPosition; --i) {
            L[i + 1] = L[i];
        }
    }

    @Override
    public T remove(int givenPosition) {
        // T temp = list.get(givenPosition);
        // list.remove(givenPosition);

        T temp = null;
        if (givenPosition > -1 && givenPosition < numOfEntries) {
            temp = L[givenPosition];
            for (int i = givenPosition + 1; i < numOfEntries; ++i) {
                L[i - 1] = L[i];
            }
            L[numOfEntries - 1] = null;
            --numOfEntries;
        }

        return temp;
    }

    public int getIndexOf(T target) {
        int index = -1;
        for(int i = 0; i < numOfEntries; ++i) {
            if(target.equals(L[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void clear() {
//        while (!isEmpty()) {
//            list.removeAll(list);
//        }

        for(int i = 0; i < numOfEntries; ++i) {
            L[i] = null;
        }
        numOfEntries = 0;
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
//        T temp = getEntry(givenPosition);
//        list.set(givenPosition, newEntry);
//        return temp;

        T temp = L[givenPosition];
        L[givenPosition] = newEntry;
        return temp;
    }

    @Override
    public T getEntry(int givenPosition) {
//        return list.get(givenPosition - 1);
        if (givenPosition == 0) {
            return L[givenPosition];
        }
        return L[givenPosition - 1];
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[getLength()];

        for (int i = 1; i < result.length; ++i) {
            result[i] = getEntry(i);
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
//        boolean found = false;
//        for (int i = 0; i < getLength(); ++i) {
//            if(anEntry.equals(getEntry(i))) {
//                found = true;
//            }
//        }
//
//        return found;

        boolean found = false;
        for (int i = 0; i < numOfEntries; ++i) {
            if(anEntry.equals(L[i])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getLength() {
        return numOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }
}
