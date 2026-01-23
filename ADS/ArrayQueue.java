import java.util.Scanner;

class ArrayQueueStructure {
    int max;
    int arr[];
    int front;
    int rear;

    ArrayQueueStructure(int max) {
        this.max = max;
        this.arr = new int[max];
        this.front = -1;
        this.rear = -1;
    }

    void enqueue(int data) {

        // Queue overflow condition
        if (rear == max - 1) {
            System.out.println("Queue overflow");
            return;
        }

        // If queue is empty
        if (front == -1) {
            front = 0;
        }

        rear++;
        arr[rear] = data;
        System.out.println(data + " enqueued");
    }

    void dequeue() {

        // Queue underflow condition
        if (front == -1) {
            System.out.println("Queue underflow");
            return;
        }

        int dequeued = arr[front];

        // If only one element was present
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        System.out.println("Element removed is: " + dequeued);
    }

    void peekFront() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element is: " + arr[front]);
    }

    void peekRear() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Rear element is: " + arr[rear]);
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class ArrayQueue {
    public static void main(String[] args) {

        ArrayQueueStructure queue = new ArrayQueueStructure(5);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Peek Front\n5. Peek Rear\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    queue.peekFront();
                    break;
                case 5:
                    queue.peekRear();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
