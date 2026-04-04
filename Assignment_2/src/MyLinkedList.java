import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
    }

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
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;
    }

    @Override
    public void add(int index, T item) {
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
    public T get(int index) {
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
        head.prev = null;
        size--;
    }

    @Override
    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getCapacity() {
        return 0; // REMOVE ===================================================
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

    private class MyNode<E> {
        E element;
        MyNode<E> prev;
        MyNode<E> next;

        public MyNode(E element) {
            this.element = element;
        }
    }
}
