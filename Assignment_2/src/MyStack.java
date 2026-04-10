public class MyStack<T> {
    private MyList<T> data = new MyLinkedList<>();

    public MyStack() {
    }

    public void push(T item) {
        data.add(item);
    }

    public void pop() {
        data.removeLast();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }

    public T peek() {
        return data.getLast();
    }
}
