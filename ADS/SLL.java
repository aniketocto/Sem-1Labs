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

    public List() {
        this.head = null;
    }

    void insert(int data) {
        // create a new node
        Node newNode = new Node(data);

        // if its first node
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    void delete(int data) {
        // Search for the node to be deleted
        boolean found = false;
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data == data) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        }

        // data is not found
        if (!found) {
            System.out.println("Element " + data + " not found in the list.");
            return;
        }

        // data is found
        // deleting head node
        if (current == head) {
            head = head.next;
        }
        // deleting last node
        else if (current.next == null) {
            previous.next = null;
        }
        // deleting middle node
        else {
            previous.next = current.next;
        }
    }

    void Search(int data) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.data == data) {
                found = true;
                break;
            }
            current = current.next;
        }

        if (found) {
            System.out.println("Element " + data + " is found in the list.");
        } else {
            System.out.println("Element " + data + " is not found in the list.");
        }
    }

    void Count() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("The count of data in the list is: " + count);
    }

    void Display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }
}

public class SLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List list = new List();
        int ch;

        do {
            System.out.println("\nSingly Linked List\n");
            System.out.println("1. Insert at the end of the SLL");
            System.out.println("2. Delete an element");
            System.out.println("3. Serach for an element");
            System.out.println("4. Count the number of nodes in the SLL");
            System.out.println("5. Display the SLL");
            System.out.println("6. Exit\n");
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
                    System.out.println("-----!!!Exiting!!!-----");
                    break;
                default:
                    System.out.println("Incorrect Choice");
                    break;
            }
        } while (ch != 6);
    }
}