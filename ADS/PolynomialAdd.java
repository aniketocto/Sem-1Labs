class Node {
    int coeff;
    int exp;
    Node next;

    Node(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        this.next = null;
    }
}

class PolynomialTemp {
    Node head;
    Node tail;

    public PolynomialTemp() {
        this.head = null;
        this.tail = null;
    }

    void insert(int c, int e) {
        Node newNode = new Node(c, e);

        // if it is a first node
        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null && curr.exp > newNode.exp) {
            prev = curr;
            curr = curr.next;
        }

        // Insert t
        if (curr == head) // head node insertion
        {
            newNode.next = curr;
            head = newNode;
        } else if (curr == null) {
            prev.next = newNode;
        } else {
            prev.next = newNode;
            newNode.next = curr;
        }
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.coeff + "x^" + curr.exp + " + ");
            curr = curr.next;
        }
    }

    static PolynomialTemp add(PolynomialTemp p1, PolynomialTemp p2) {
        PolynomialTemp p3 = new PolynomialTemp();
        Node curr1 = p1.head;
        Node curr2 = p2.head;
        while (curr1 != null && curr2 != null) {
            if (curr1.exp == curr2.exp) {
                p3.insert(curr1.coeff + curr2.coeff, curr1.exp);
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1.exp > curr2.exp) {
                p3.insert(curr1.coeff, curr1.exp);
                curr1 = curr1.next;
            } else {
                p3.insert(curr2.coeff, curr2.exp);
                curr2 = curr2.next;
            }
        }
        return p3;
    }
}

public class PolynomialAdd {
    public static void main(String[] args) {
        PolynomialTemp p1 = new PolynomialTemp();
        PolynomialTemp p2 = new PolynomialTemp();

        p1.insert(3, 2);
        p1.insert(2, 1);
        p1.insert(1, 0);
        p1.display();

        p2.insert(5, 2);
        p2.insert(4, 1);
        p2.insert(3, 0);
        p2.display();

        PolynomialTemp p3 = PolynomialTemp.add(p1, p2);
        p3.display();
    }
}
