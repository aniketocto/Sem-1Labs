public class Insertionsort {

    public static void main(String[] args) {

        int[] arr = { 5, 3, 8, 4, 2 };
        insertionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}