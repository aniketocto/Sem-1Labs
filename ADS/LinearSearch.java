import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int i, num, key, flag = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        num = sc.nextInt();

        int[] arr = new int[5];
        for (i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to be searched: ");
        key = sc.nextInt();

        for (i = 0; i < num; i++) {
            if (arr[i] == key) {
                flag = 1;
                System.out.println("Element found at index: " + i);
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Element not found");
        }
    }
}
