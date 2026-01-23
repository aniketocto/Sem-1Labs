import java.util.Scanner;

class Stack {
    int arr[];
    int tos;
    int max;

    Stack(int max) {
        this.arr = new int[max];
        this.tos = -1;
        this.max = max;
    }

    void push(int data) {
        if (tos == max - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arr[++tos] = data;
    }

    void pop() {
        if (tos == -1) {
            System.out.println("Stack underflow");
            return;
        }

        int popped = arr[tos--];
        System.out.println("Element removed is: " + popped);
    }

    void peek() {
        System.out.println(arr[tos]);
    }

    void display() {
        for (int i = tos; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}

public class ArrayStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Push\n2. Pop\n3. Display\n4. Peek\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.peek();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
