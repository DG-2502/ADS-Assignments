public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{ " + key + " " + value + " }";
        }
    }

    private HashNode[] chainArray;
    private int M = 8;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    public void print() {
        for (int i = 0; i < M; i++) {
            System.out.print(i);
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                System.out.print(" -> " + current.value);
                current = current.next;
            }
            System.out.println();
        }

        System.out.println(size);
        System.out.println(((float) size) / M);
    }

    private int hash(K key) {
//        return ((int) key % M);
        return (key.hashCode() & Integer.MAX_VALUE) % M;
    }

    public void put(K key, V value) {
        int hash = hash(key);

        HashNode<K, V> current = chainArray[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[hash];
        chainArray[hash] = newNode;
        size++;

        if (((float) size / M) > 0.75) {
            System.out.println("Need to rehash " + size + " " + M);
            rehash();
        }
    }

    private void rehash() {
        HashNode[] old = chainArray;
        int oldM = M;
        M *= 2;
        chainArray = new HashNode[M];
        size = 0;

        for (int i = 0; i < oldM; i++) {
            HashNode<K, V> current = old[i];
            for (; current != null; current = current.next) {
                put(current.key, current.value);
            }
        }
    }

    public V get(K key) {
        int hash = hash(key);

        HashNode<K, V> current = chainArray[hash];
        for (; current != null; current = current.next) {
            if (current.key == key) {
                return current.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        int hash = hash(key);

        HashNode<K, V> current = chainArray[hash];
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    chainArray[hash] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            for (; current != null; current = current.next) {
                if (current.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            for (; current != null; current = current.next) {
                if (current.value.equals(value)) {
                    return current.key;
                }
            }
        }
        return null;
    }
}
