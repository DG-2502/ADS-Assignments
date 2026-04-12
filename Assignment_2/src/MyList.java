//public interface MyList<T>{
public interface MyList<T> extends Iterable<T>{
    /**
     * Add element to the list
     * @param item
     */
    void add(T item);
    /**
     * Replace element of the list at the given index
     * @param index
     * @param item
     */
    void set(int index, T item);
    /**
     * Insert an element at the given index
     * @param index
     * @param item
     */
    void add(int index, T item);
    /**
     * Add the element to the list at the beginning
     * @param item
     */
    void addFirst(T item);
    /**
     * Add the element to the list at the end
     * @param item
     */
    void addLast(T item);
    /**
     * Returns the element of the list at the given index
     * @param index
     * @return
     */
    T get(int index);
    /**
     * Returns first element of the list
     * @return
     */
    T getFirst();
    /**
     * Returns last element of the list
     * @return
     */
    T getLast();
    /**
     * Removes an element from the list at the given index
     * @param index
     */
    void remove(int index);
    /**
     * Removes first element from the list
     */
    void removeFirst();
    /**
     * Removes last element from the list
     */
    void removeLast();
    /**
     * Sort the list in the ascending order
     */
    void sort();
    /**
     * Returns index of the given object in the list
     * @param object
     * @return
     */
    int indexOf(Object object);
    /**
     * Returns last index of the object in the array
     * @param object
     * @return
     */
    int lastIndexOf(Object object);
    /**
     * Check whether the array contains the object
     * @param object
     * @return
     */
    boolean exists(Object object);
    /**
     * Returns the array on objects
     * @return
     */
    public Object[] toArray();
    /**
     * Delete all object from the list
     */
    void clear();
    /**
     * Returns the amount of elements in the list
     * @return
     */
    int size();
}
