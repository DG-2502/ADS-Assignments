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

//    MyList<Integer> array = new MyLinkedList<>();
//    for (int i = 0; i < 10; i++) {
//        array.add(i);
//    }
//    for (Integer elem : array) {
//        System.out.println(elem);
//    }
//
//    System.out.println();
//    array.set(3, 10);
//    try {
//        array.add(15, 100);
//    } catch (IndexOutOfBoundsException e) {
//        array.add(5, 100);
//    }
//    array.remove(8);
//    array.removeFirst();
//    array.removeLast();
//
//    for (Integer elem : array) {
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

//    MyList<Integer> array = new MyArrayList<>();
//    array.add(10);
//    array.add(10);
//    array.add(10);
//    array.add(10);
//    for (Integer elem : array) {
//        System.out.println(elem);
//    }
//    System.out.println(array.size());
//    array.clear();
//    System.out.println(array.size());
//    for (Integer elem : array) {
//        System.out.println(elem);
//    }

    MyQueue<Integer> queue = new MyQueue<>();

    System.out.println(queue.isEmpty());
    System.out.println(queue.size());
    queue.push(10);
    queue.push(120);
    queue.push(1202);
    System.out.println(queue.size());
    System.out.println(queue.front());
    System.out.println(queue.back());
    queue.pop();
    System.out.println(queue.front());
    System.out.println(queue.back());
    System.out.println(queue.isEmpty());
    queue.pop();
    queue.pop();
    System.out.println(queue.size());
    System.out.println(queue.isEmpty());
}


