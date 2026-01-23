import java.util.Scanner;

class Maxheap {
    int[] arr;
    int count;
    int capacity;

    public Maxheap(int size) {
        arr = new int[size];
        capacity = size;
        count = 0;
    }

    // Parent
    int parent(int i) {
        return (i - 1) / 2;
    }

    // Left Child
    int leftChild(int i) {
        return (2 * i + 1);
    }

    // Right Child
    int rightChild(int i) {
        return (2 * i + 2);
    }

    // Insert
    public void insert(int x) {
        if (count == capacity) {
            System.out.println("Heap is full");
            return;
        }
        arr[count] = x;
        int i = count;
        count++;

        while (i != 0 && arr[parent(i)] < arr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Display
    public void display() {
        if (count == 0) {
            System.out.println("Heap is empty");
            return;
        }
        System.out.print("Heap elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void delete() {
        if (count == 0) {
            System.out.println("Heap is empty");
            return;
        }
        int temp = arr[0];
        arr[0] = arr[count - 1];
        count--;
        heapDown(0);
        System.out.println("Deleted element: " + temp);
    }

    void heapDown(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < count && arr[left] > arr[largest])
            largest = left;
        if (right < count && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapDown(largest);
        }

    }
}

public class Heap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Maxheap maxHeap = new Maxheap(10);
        int ch;

        do {
            System.out.println("\nHeap\n");
            System.out.println("1. Insert an element in the heap");
            System.out.println("2. Display the heap");
            System.out.println("3. Delete an element from the heap");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter a value to insert: ");
                    int x = sc.nextInt();
                    maxHeap.insert(x);
                    break;
                case 2:
                    maxHeap.display();
                    break;
                case 3:
                    maxHeap.delete();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (ch != 4);
    }
}
