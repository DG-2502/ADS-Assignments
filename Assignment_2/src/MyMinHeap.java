public class MyMinHeap<T> {
    MyList<T> data = new MyArrayList<>();

    public MyMinHeap() {
    }

    public MyList<T> toArray() {
        return data;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return data.size();
    }

    public T getMin() {
        return data.get(0);
    }

    public T extractMin() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("the heap is empty");
        }
        T elem = getMin();

        swap(0, size() - 1);
        data.removeLast();
        heapify(0);

        return elem;
    }

    public void insert(T element) {
        data.add(element);

        traverseUp(size() - 1);
    }

    private void heapify(int index) {
        while (true) {
            int left = leftChildOf(index);
            int right = rightChildOf(index);
            int child = left;
            if (left == -1) {
                break;
            }
            if (right != -1) {
                if (data.get(left).hashCode() > data.get(right).hashCode()) {
                    child = right;
                }
            }

            if (data.get(index).hashCode() > data.get(child).hashCode()) {
                swap(index, child);
                index = child;
            } else {
                break;
            }
        }
    }

    private void traverseUp(int index) {
        int parent;
        while (true) {
            parent = parentOf(index);

            if (data.get(parent).hashCode() <= data.get(index).hashCode()) {
                break;
            }

            swap(parent, index);

            index = parent;
        }
    }

    private int leftChildOf(int index) {
        int ind = index * 2 + 1;
        if (ind > (size() - 1)) {
            return -1;
        }
        return ind;

    }

    private int rightChildOf(int index) {
        int ind = index * 2 + 2;
        if (ind > (size() - 1)) {
            return -1;
        }
        return ind;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }
}
