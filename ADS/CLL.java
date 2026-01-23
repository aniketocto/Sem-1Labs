import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    Node head;
    Node tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    void insert(int data) {
        // Make a new Node
        Node newNode = new Node(data);

        // if its is the first node int he list
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node previous = null;
        boolean found = false;

        // traverse circular list
        do {
            if (current.data == data) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Element " + data + " not found in the list.");
            return;
        }

        // CASE 1: only one node
        if (head == tail && current == head) {
            head = null;
            tail = null;
        }
        // CASE 2: deleting head
        else if (current == head) {
            head = head.next;
            tail.next = head;
        }
        // CASE 3: deleting tail
        else if (current == tail) {
            tail = previous;
            tail.next = head;
        }
        // CASE 4: deleting middle node
        else {
            previous.next = current.next;
        }
    }

    void Count() {
        Node current = head;
        int count = 0;

        if (current == null) {
            System.out.println("List is empty.");
            return;
        }

        do {
            count++;
            current = current.next;
        } while (current != head);
        System.out.println("The count of data in the list is: " + count);
    }

    void Search(int data) {
        Node current = head;
        boolean found = false;

        do {
            if (current.data == data) {
                found = true;
                break;
            }
            current = current.next;
        } while (current != head);

        if (found) {
            System.out.println("Element " + data + " is found in the list.");
        } else {
            System.out.println("Element " + data + " is not found in the list.");
        }
    }

    void Display() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty.");
        }
        System.out.print("Head->");
        do {
            System.out.print(current.data + "->");
            current = current.next;
        } while (current != head);

        System.out.print("Back to head");
    }

}

public class CLL {
    public static void main(String[] args) {
        List list = new List();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("Queue");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Count");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter a value to insert: ");
                    int x = sc.nextInt();
                    list.insert(x);
                    break;
                case 2:
                    System.out.print("Enter a value to delete: ");
                    int z = sc.nextInt();
                    list.delete(z);
                    break;
                case 3:
                    System.out.print("Enter a value: to search ");
                    int y = sc.nextInt();
                    list.Search(y);
                    break;
                case 4:
                    list.Count();
                    break;
                case 5:
                    list.Display();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (ch != 6);
    }
}
