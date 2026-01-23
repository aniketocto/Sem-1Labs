import java.util.Scanner;

class CircularQueueStructure {
    int max;
    int arr[];
    int front;
    int rear;
    int count;

    CircularQueueStructure(int max) {
        this.max = max;
        this.arr = new int[max];
        this.front = -1;
        this.rear = -1;
        this.count = 0;
    }

    void enqueue(int data) {
        // Queue overflow condition
        if (count == max) {
            System.out.println("Queue overflow");
            return;
        }

        // If queue is empty
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % max;
        arr[rear] = data;
        count++;
        System.out.println(data + " enqueued");
    }

    void dequeue() {
        // Queue underflow condition
        if (count == 0) {
            System.out.println("Queue underflow");
            return;
        }

        int dequeued = arr[front];
        front = (front + 1) % max;
        count--;

        // If queue becomes empty
        if (count == 0) {
            front = -1;
            rear = -1;
        }

        System.out.println("Element removed is: " + dequeued);
    }

    void peekFront() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element is: " + arr[front]);
    }

    void peekRear() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Rear element is: " + arr[rear]);
    }

    void display() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements are:");
        for (int i = 0; i < count; i++) {
            System.out.println(arr[(front + i) % max]);
        }
    }
}

public class CircularQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CircularQueueStructure queue = new CircularQueueStructure(5);
        int choice;

        do {
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Peek\n5. Exit");
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
                    System.out.println("1. Peek Front\n2. Peek Rear");
                    System.out.print("Enter your choice: ");
                    int peekChoice = scanner.nextInt();
                    if (peekChoice == 1) {
                        queue.peekFront();
                    } else if (peekChoice == 2) {
                        queue.peekRear();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
