package sprint4;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
        int[] arrSorted = sortArraySelectionSort(arr);

        Arrays.stream(arrSorted).forEach( value -> System.out.println(value) );
    }

    public static int[] sortArraySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                min = arr[minIndex];;
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        return arr;
    }

}
