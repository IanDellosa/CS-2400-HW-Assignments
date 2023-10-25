package Problem2;

/**
 * An interface for a collection that has a first entry
 * and a last entry.
 * 
 * @author Frank M. Carrano
 * @version 5.0
 */
public interface DoubleEndedInterface<T> {
    /**
     * Adds a new entry to the beginning of this collection.
     * 
     * @param newEntry The object to be added as a new entry.
     */
    public void addFirst(T newEntry);

    /**
     * Adds a new entry to the end of this collection.
     * 
     * @param newEntry The object to be added as a new entry.
     */
    public void addLast(T newEntry);

    /**
     * Removes and returns the first entry in this collection.
     * 
     * @return A reference to the removed entry or null, if
     *         the list was empty.
     */
    public T removeFirst();

    /**
     * Removes and returns the last entry in this collection.
     * 
     * @return A reference to the removed entry or null, if
     *         the list was empty.
     */
    public T removeLast();

    /**
     * Retrieves the first entry in this collection.
     * 
     * @return A reference to the first entry or null, if
     *         the list is empty.
     */
    public T getFirst();

    /**
     * Retrieves the last entry in this collection.
     * 
     * @return A reference to the last entry or null, if
     *         the list is empty.
     */
    public T getLast();

    /** Moves the first entry in this collection to the end of the list. */
    public void moveToEnd();
} // end DoubleEndedInterface
