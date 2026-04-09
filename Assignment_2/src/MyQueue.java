public class MyQueue<T> {
    MyList<T> data = new MyLinkedList<>();

    public MyQueue() {
    }

    public void push(T item) {
        data.add(item);
    }

    public void pop() {
        data.removeFirst();
    }

    public T front() {
        return data.getFirst();
    }

    public T back() {
        return data.getLast();
    }

    public boolean isEmpty(){
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }
}
