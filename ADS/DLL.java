import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DList {
    Node head;
    Node tail;

    DList() {
        this.head = null;
        this.tail = null;
    }

    void insert(int data) {
        // Make a new Node
        Node newNode = new Node(data);

        // If is is the first node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        // Find node
        while (curr != null && curr.data != data) {
            curr = curr.next;
        }
        // Not found
        if (curr == null) {
            System.out.println("Element " + data + " is not found in the list.");
            return;
        }
        // Case 1 — only node
        if (curr == head && curr == tail) {
            head = null;
            tail = null;
        }
        // Case 2 — delete head
        else if (curr == head) {
            head = head.next;
            head.prev = null;
        }
        // Case 3 — delete tail
        else if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // Case 4 — middle node
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        System.out.println("Deleted: " + data);
    }

    void search(int data) {
        Node curr = head;
        boolean found = false;

        while (curr != null) {
            if (curr.data == data) {
                found = true;
                break;
            }
            curr = curr.next;
        }

        if (found) {
            System.out.println("Element " + data + " is found in the list.");
        } else {
            System.out.println("Element " + data + " is not found in the list.");
        }
    }

    void Count() {
        Node curr = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        System.out.println("The count of data in the list is: " + count);
    }

    void Display()
    {
        Node curr = head;
        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.print("null");

        curr = tail;
        System.out.print("\nTail -> ");
        while (curr != null) {
            System.out.print( curr.data);
            curr = curr.prev;
        }
        System.out.println("null");
    }
}

public class DLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DList list = new DList();
        int ch;

        do {
            System.out.println("\nDoubly Linked List\n");
            System.out.println("1. Insert at the end of the DLL");
            System.out.println("2. Delete an element");
            System.out.println("3. Serach for an element");
            System.out.println("4. Count the number of nodes in the DLL");
            System.out.println("5. Display the DLL");
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
                    list.search(y);
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
                    System.out.println("Invalid choice.");
            }
        } while (ch != 6);
    }
}
