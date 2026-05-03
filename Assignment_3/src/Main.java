import org.w3c.dom.Node;

void main() {
//    MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
//
//    Random r = new Random();
//
//    for (int i = 0; i < 1000; i++) {
//        table.put(new MyTestingClass(), r.nextInt());
//    }


//    table.print();

    BST<Integer, Integer> tree = new BST<>();

//    tree.put(34, 1);
//    tree.put(29, 1);
//    tree.put(50, 1);
//    tree.put(24, 1);
//    tree.put(30, 1);
//    tree.put(18, 1);
//    tree.put(47, 1);
//    tree.put(72, 1);
//    tree.put(38, 1);
//    tree.put(7, 10);
//    tree.put(8, 13);

//    tree.inOrder(tree.root);
//    System.out.println();
//    System.out.println(tree.size());
//    System.out.println(tree.get(8));

    tree.put(65, 1);
    tree.put(28, 1);
    tree.put(82, 1);
    tree.put(19, 1);
    tree.put(63, 1);
    tree.put(73, 1);
    tree.put(92, 1);
    tree.put(16, 1);
    tree.put(42, 1);
    tree.put(67, 1);
    tree.put(91, 1);
    tree.inOrder(tree.root);
    tree.delete(65);
    tree.delete(67);
    tree.delete(73);
    tree.delete(82);
    tree.delete(91);
    tree.delete(92);
    tree.delete(28);
    tree.delete(42);
    tree.delete(63);
//    tree.delete(19);
    tree.delete(16);
    tree.delete(19);
//    System.out.println(tree.getRootKey());
    System.out.println();
    tree.inOrder(tree.root);
    System.out.println();
    System.out.println(tree.size());
    for (BST.Node elem : tree) {
        System.out.print(elem.getKey() + " ");
    }
}
