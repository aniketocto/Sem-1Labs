import java.util.Scanner;

public class Shellsort {
    public static void main(String[] args) {

        int num, i, j, gap;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of integers to sort:");
        num = sc.nextInt();

        int array[] = new int[num];

        System.out.println("Enter " + num + " integers:");
        for (i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }

        for (gap = num / 2; gap > 0; gap = gap / 2) {

            for (i = gap; i < num; i++) {
                int temp = array[i];
                j = i;

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }

                array[j] = temp;
            }
        }
        System.out.println("Sorted Array:");
        for (i = 0; i < num; i++) {
            System.out.println(array[i]);
        }

        sc.close();
    }
}
