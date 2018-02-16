package testarrays;

import java.util.Scanner;
import java.util.Arrays;

public class TestArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input size of array.
        System.out.print("Input size of array : ");
        int sizeOfArr = scanner.nextInt();

        int summ = 0;
        int even = 0;
        int notEven = 0;

        // Create array.
        int arr[] = new int[sizeOfArr];

        // Fill.
        for (int i = 0; i < sizeOfArr; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println();

        // Print resulted array.
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // Print summ, avarage.
        for (int i = 0; i < sizeOfArr; i++) {
            summ += arr[i];
        }
        System.out.println("Summ is : " + summ);
        System.out.println("Average is : " + (summ / sizeOfArr));

        // Print even, not even.
        // Print summ, avarage.
        System.out.print("even : ");
        for (int i = 0; i < sizeOfArr; i++) {
            if (arr[i] % 2 == 0) {
                even = arr[i];
                System.out.print(even + " ");
            }
        }
        System.out.println("");

        System.out.print("not even : ");
        for (int i = 0; i < sizeOfArr; i++) {
            if (arr[i] % 2 != 0) {
                notEven = arr[i];
                System.out.print(notEven + " ");
            }
        }
        System.out.println("\n");
        
// Sort by loop.
        System.out.println("Sort by temp");
        // Sort down.
        int temp = 0;
        for (int i = 0; i < sizeOfArr - 1; i++) {
            for (int j = 0; j < (sizeOfArr - i - 1); j++) {
                if (arr[j + 1] > arr[j]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // Sort up.
        for (int i = 0; i < sizeOfArr - 1; i++) {
            for (int j = 0; j < (sizeOfArr - i - 1); j++) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        
// Sort by Arrays class methods.
        System.out.println("Sort by Arrays methods");
        // Sort up.
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("\n");
    }
}