import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
    }

    private void checkIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is too big");
        }
    }

    /**
     * Add element to the list
     * @param item
     */
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        MyNode<T> newMode = new MyNode<>(item);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newMode.next = current;
        newMode.prev = current.prev;
        current.prev.next = newMode;
        current.prev = newMode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        if (head == null) {
            add(item);
            return;
        }
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public T getFirst() {
        return head.element;
    }

    @Override
    public T getLast() {
        return tail.element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size - i - 1; j++) {
                if (get(j).hashCode() > get(j + 1).hashCode()) {
                    T temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        MyIterator iterator = new MyIterator();
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (elem == object) {
                return index;
            }
            index++;
        }

        throw new NoSuchElementException("No element");
    }

    @Override
    public int lastIndexOf(Object object) {
        int ind = -1;
        int index = 0;
        MyIterator iterator = new MyIterator();
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (elem == object) {
                ind = index;
            }
            index++;
        }
        if (ind == -1) {
            throw new NoSuchElementException("No element");
        }
        return ind;
    }

    @Override
    public boolean exists(Object object) {
        MyIterator iterator = new MyIterator();
        while (iterator.hasNext()) {
            T elem = iterator.next();
            if (elem == object) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyIterator iterator = new MyIterator();
        int index = 0;
        while (iterator.hasNext()) {
            array[index] = iterator.next();
            index++;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
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

    private class MyNode<E> {
        E element;
        MyNode<E> prev;
        MyNode<E> next;

        public MyNode(E element) {
            this.element = element;
        }
    }
}
