public class MyQueue<T> {
    MyList<T> data = new MyLinkedList<>();

    public MyQueue() {
    }

    public void enqueue(T item) {
        data.add(item);
    }

    public void dequeue() {
        data.removeFirst();
    }

    public T peek() {
        return data.getFirst();
    }

    public boolean isEmpty(){
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }
}
