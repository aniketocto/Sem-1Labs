class HashTable {
    private Integer[] table;
    private int size;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Integer[capacity];
    }

    public int Hash(int key) {
        return key % capacity;
    }

    public void insert(int key) {
        if (size >= capacity) {
            System.out.println("Hash Table is full");
            return;
        }

        int index = Hash(key);

        while (table[index] != null) {
            index = (index + 1) % capacity;
        }
        table[index] = key;
        size++;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        int keys[] = { 15, 25, 35, 5, 10, 20 };

        for (int i : keys) {
            ht.insert(i);
        }

        ht.display();
    }
}