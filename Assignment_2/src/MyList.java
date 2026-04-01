//public interface MyList<T>{
public interface MyList<T> extends Iterable<T>{
    void add(T item);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
//    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
//    void sort();
    /**
     *get the size of the array
     */
    int size();
    int getCapacity();
}
