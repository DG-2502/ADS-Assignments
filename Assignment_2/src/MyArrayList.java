import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size = 0;
    private int capacity = 4;


    public MyArrayList() {
        data = new Object[capacity];
    }

    private void increaseBuffer() {
        capacity *= 2;
        Object[] data2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            data2[i] = data[i];
        }
        data = data2;
    }

    private void checkIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is too big");
        }
    }

    @Override
    public void add(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        data[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        data[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (size == capacity) {
            increaseBuffer();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

//    @Override
//    public int indexOf(Object object) {
//        int index = 0;
//        for(Object elem : data){
//            if (elem == object) {
//                return index;
//            }
//            index ++;
//        }
//
//        throw new NoSuchElementException("No element");
//    }
//
//    @Override
//    public int lasIndexOf(Object object) {
//        int ind = size - 1;
//        for(int index = ind; index > 0; index--){
//            if (data[index] == object) {
//                return index;
//            }
//        }
//
//        throw new NoSuchElementException("No element");
//    }
//
//    @Override
//    public boolean exists(Object object) {
//        return false;
//    }
//
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }

    @Override
    public void clear() {
        size = 0;
        data = new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator(){};
    }

    private class MyIterator implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            T next = get(cursor);
            cursor++;
            return next;
        }
    }
    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
