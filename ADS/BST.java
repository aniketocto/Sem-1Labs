import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;
    int cnt;

    BinarySearchTree() {
        root = null;
        cnt = 0;
    }

    // Insert
    public void insert(int x) {
        Node newNode = new Node(x);
        if (root == null) {
            root = newNode;
            cnt++;
            return;
        }

        Node current = root;
        Node prev = null;

        while (current != null) {
            prev = current;
            if (newNode.data < current.data)
                current = current.left;
            else if (newNode.data > current.data) {
                current = current.right;
            } else {
                System.out.println("Duplicate Value: " + x);
                return;
            }
        }

        if (newNode.data < prev.data)
            prev.left = newNode;
        else
            prev.right = newNode;

        cnt++;
    }

    public void Display() {
        System.out.print("Preorder Traversal: ");
        Preorder(root);
        System.out.println();
        System.out.print("Inorder Traversal: ");
        Inorder(root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        Postorder(root);
        System.out.println();
    }

    // PreOrder Traversal
    void Preorder(Node r) {
        if (r != null) {
            System.out.print(r.data + " ");
            Preorder(r.left);
            Preorder(r.right);
        }
    }

    // PostOrder Traversal
    void Postorder(Node r) {
        if (r != null) {
            Postorder(r.left);
            Postorder(r.right);
            System.out.print(r.data + " ");
        }
    }

    // InOrder Traversal
    void Inorder(Node r) {
        if (r != null) {
            Inorder(r.left);
            System.out.print(r.data + " ");
            Inorder(r.right);
        }
    }

    void Search(int x) {
        Node tmp = root;
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }

        while (tmp != null) {
            if (x == tmp.data) {
                System.out.println("Value " + x + " Found in BST");
                return;
            } else if (x < tmp.data) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        System.out.println("Value " + x + " Not Found in BST");
    }

    // Count
    public void Count() {
        System.err.println("The number of nodes present in the tree is: " + cnt);
    }

    void FindMax() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        Node tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        System.out.println("Maximum Value in BST is: " + tmp.data);
    }

    void FindMin() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        Node tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        System.out.println("Minimum Value in BST is: " + tmp.data);
    }
}

public class BST {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        int ch;

        do {
            System.out.println("\nBinary Search Tree\n");
            System.out.println("1. Insert an element in the tree");
            System.out.println("2. Display the tree");
            System.out.println("3. Search for an element in the tree");
            System.out.println("4. Count the number of nodes in the tree");
            System.out.println("5. Find the maximum element in the tree");
            System.out.println("6. Find the minimum element in the tree");
            System.out.println("7. Exit\n");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter a value to insert: ");
                    int x = sc.nextInt();
                    tree.insert(x);
                    break;
                case 2:
                    tree.Display();
                    break;
                case 3:
                    System.err.print("Enter a value to search: ");
                    int y = sc.nextInt();
                    tree.Search(y);
                    break;
                case 4:
                    tree.Count();
                    break;
                case 5:
                    tree.FindMax();
                    break;
                case 6:
                    tree.FindMin();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (ch != 7);
    }
}
