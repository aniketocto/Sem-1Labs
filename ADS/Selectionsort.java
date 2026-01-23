// import java.util.Scanner;

// public class Selectionsort {
//     public static void main(String[] args) {
//         int num, i, j, temp;

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of elements: ");
//         num = sc.nextInt();

//         System.out.println("Enter the elements: ");
//         int arr[] = new int[num];
//         for (i = 0; i < num; i++) {
//             arr[i] = sc.nextInt();
//         }

//         // Selection Sort
//         for (i = 0; i < num; i++) {
//             int minIdx = i;

//             for (j = i + 1; j < num; j++) {
//                 if (arr[j] < arr[minIdx]) {
//                     minIdx = j;
//                 }
//             }

//             temp = arr[i];
//             arr[i] = arr[minIdx];
//             arr[minIdx] = temp;
//         }

//         System.out.println("Sorted array: ");
//         for (i = 0; i < num; i++) {
//             System.out.println(arr[i]);
//         }

//     }
// }

public class Selectionsort {

    public static void main(String[] args) {

        int[] arr = { 64, 25, 12, 22, 11 };
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}