void main(String[] args) {
    MyList<Integer> da_array = new MyArrayList<>();

    for (int i = 0; i < 8; i++) {
        da_array.add(i);
    }

    da_array.addFirst(10);
    da_array.set(1, 100);
    da_array.add(5, 15);
//    System.out.println(da_array.size());
//    System.out.println(da_array.getCapacity());
//
//    System.out.println();
//    for (int i = 0; i < da_array.size(); i++){
//        System.out.println(da_array.get(i));
//    }
//    System.out.println();
//    System.out.println(da_array.getFirst());
//    System.out.println(da_array.getLast());

//    System.out.println();
//
//    da_array.remove(3);
//
//    System.out.println(da_array.size());
//    System.out.println(da_array.getCapacity());
//
//    System.out.println();
//    for (Integer num : da_array) {
//        System.out.println(num);
//    }
//
//    da_array.removeFirst();
//    da_array.removeLast();
//
//    System.out.println();
//    System.out.println(da_array.size());
//    System.out.println(da_array.getCapacity());
//
//    System.out.println();
//    for (Integer num : da_array) {
//        System.out.println(num);
//    }

//    MyList<Integer> queue = new MyLinkedList<>();
//    for (int i = 0; i < 10; i++) {
//        queue.add(i);
//    }
//    for (Integer elem : queue) {
//        System.out.println(elem);
//    }
//
//    System.out.println();
//    queue.set(3, 10);
//    try {
//        queue.add(15, 100);
//    } catch (IndexOutOfBoundsException e) {
//        queue.add(5, 100);
//    }
//    queue.remove(8);
//    queue.removeFirst();
//    queue.removeLast();
//
//    for (Integer elem : queue) {
//        System.out.println(elem);
//    }

//    MyStack<Integer> stack = new MyStack<>();
//
//    System.out.println(stack.isEmpty());
//    System.out.println(stack.size());
//    stack.push(10);
//    System.out.println(stack.size());
//    System.out.println(stack.top());
//    stack.pop();
//    System.out.println(stack.isEmpty());

//    MyList<Integer> queue = new MyArrayList<>();
//    queue.add(10);
//    queue.add(10);
//    queue.add(10);
//    queue.add(10);
//    for (Integer elem : queue) {
//        System.out.println(elem);
//    }
//    System.out.println(queue.size());
//    queue.clear();
//    System.out.println(queue.size());
//    for (Integer elem : queue) {
//        System.out.println(elem);
//    }

//    MyQueue<Integer> queue = new MyQueue<>();
//
//    System.out.println(queue.isEmpty());
//    System.out.println(queue.size());
//    queue.push(10);
//    queue.push(120);
//    queue.push(1202);
//    System.out.println(queue.size());
//    System.out.println(queue.front());
//    System.out.println(queue.back());
//    queue.pop();
//    System.out.println(queue.front());
//    System.out.println(queue.back());
//    System.out.println(queue.isEmpty());
//    queue.pop();
//    queue.pop();
//    System.out.println(queue.size());
//    System.out.println(queue.isEmpty());

//    MyMinHeap<Integer> heap = new MyMinHeap<>();
//    heap.insert(9);
//    heap.insert(20);
//    heap.insert(15);
//    heap.insert(1);
//    heap.insert(3);
//    heap.insert(10);
//    heap.insert(9);
//    heap.insert(5);
//    heap.insert(23);
//    heap.insert(13);
//    heap.insert(14);
//    heap.insert(13);
//    heap.insert(15);
//    heap.insert(19);
//
//    MyList<Integer> queue = heap.toArray();
//    for (Integer elem : queue){
//        System.out.println(elem);
//    }
//    System.out.println();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//    heap.extractMin();
//
//    queue = heap.toArray();
//    for (Integer elem : queue){
//        System.out.println(elem);
//    }
//
//    MyList<Integer> array = new MyArrayList<>();
//    array.add(10);
//    array.add(11);
//    array.add(12);
//    array.add(10);
//
//    System.out.println(array.indexOf(10));
//    System.out.println(array.lastIndexOf(10));
//    System.out.println(array.exists(10));
//    System.out.println(array.exists(13));
//    Object[] ar = array.toArray();
//    for (Object elem : ar){
//        System.out.println(elem);
//    }
//    array.sort();
//    ar = array.toArray();
//    System.out.println();
//    for (Object elem : ar){
//        System.out.println(elem);
//    }

    MyList<Integer> queue = new MyLinkedList<>();
    queue.add(10);
    queue.add(11);
    queue.add(12);
    queue.add(10);

    System.out.println(queue.indexOf(10));
    System.out.println(queue.lastIndexOf(10));
    System.out.println(queue.exists(10));
    System.out.println(queue.exists(13));
    Object[] arr = queue.toArray();
    for (Object elem : arr){
        System.out.println(elem);
    }

    queue.sort();
    arr = queue.toArray();
    System.out.println();
    for (Object elem : arr){
        System.out.println(elem);
    }
}


