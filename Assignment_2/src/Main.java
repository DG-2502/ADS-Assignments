void main() {
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

    System.out.println();

    da_array.remove(3);

    System.out.println(da_array.size());
    System.out.println(da_array.getCapacity());

    System.out.println();
    for (Integer num : da_array) {
        System.out.println(num);
    }

    da_array.removeFirst();
    da_array.removeLast();

    System.out.println();
    System.out.println(da_array.size());
    System.out.println(da_array.getCapacity());

    System.out.println();
    for (Integer num : da_array) {
        System.out.println(num);
    }
}


