import java.util.Iterator;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Node> {
    public Node root;
    private int size = 0;

    public class Node {
        private K key;
        private V value;
        private Node left, right;
        private Node parent;

        public Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }

    public void put(K key, V value) {
        size++;
        if (root == null) {
            root = new Node(key, value, null);
            return;
        }

        Node parent = null;
        Node current = root;
        while (current != null) {
            parent = current;
            int cmp = current.key.compareTo(key);
            if (cmp > 0) {
                current = current.left;
            }
            if (cmp < 0) {
                current = current.right;
            }
            if (cmp == 0) {
                current.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value, parent);
        int cmp = parent.key.compareTo(key);
        if (cmp > 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = current.key.compareTo(key);
            if (cmp > 0) {
                current = current.left;
            }
            if (cmp < 0) {
                current = current.right;
            }
            if (cmp == 0) {
                return current.value;
            }
        }

        return null;
    }

    public void delete(K key) {
        Node current = root;

        if (size == 1 & current.key.equals(key)) {
            size--;
            root = null;
            return;
        }

        int cmp;
        while (current != null) {
            cmp = current.key.compareTo(key);
            if (cmp > 0) {
                current = current.left;
            } else if (cmp < 0) {
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) {
            return;
        }

        Node parent = current.parent;
        size--;
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
                root.parent = null;
            } else if (parent.left != null && parent.left.key == current.key) {
                parent.left = current.right;
                if (parent.left != null) {
                    parent.left.parent = parent;
                }
            } else {
                parent.right = current.right;
                if (parent.right != null) {
                    parent.right.parent = parent;
                }
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
                root.parent = null;
            } else if (parent.left != null && parent.left.key == current.key) {
                parent.left = current.left;
                parent.left.parent = parent;
            } else {
                parent.right = current.left;
                parent.right.parent = parent;
            }
        } else {
            Node smallest = current;

            smallest = smallest.right;
            while (smallest != null & smallest.left != null) {
                smallest = smallest.left;
            }
            Node parentSmallest = smallest.parent;


            if (parentSmallest.left.key == smallest.key) {
                parentSmallest.left = smallest.right;
                if (parentSmallest.left != null) {
                    parentSmallest.left.parent = parentSmallest;
                }
            } else {
                parentSmallest.right = smallest.right;
                if (parentSmallest.right != null) {
                    parentSmallest.right.parent = parentSmallest;
                }
            }

            current.key = smallest.key;
            current.value = smallest.value;
        }
    }

    public int size() {
        return size;
    }

    public Iterator<BST.Node> iterator() {
        return new Iterator<BST.Node>() {
            Node current = mostLeft(root);

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Node next() {
                Node ret = current;

                if (current.right != null) {
                    current = mostLeft(current.right);
                } else {
                    Node child = current;
                    Node parent = current.parent;

                    while (parent != null && parent.right != null && parent.right.key == child.key) {
                        child = parent;
                        parent = parent.parent;
                    }

                    current = parent;
                }

                return ret;
            }
        };
    }

    private Node mostLeft(Node current) {
        while (current != null && current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    public K getRootKey() {
        return root.key;
    }
}
