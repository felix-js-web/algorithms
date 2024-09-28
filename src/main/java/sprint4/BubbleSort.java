package sprint4;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
        int[] arrSorted = sortArrayBubbleSortT(arr);

        Arrays.stream(arrSorted).forEach(value -> System.out.println(value));
    }

    public static int[] sortArrayBubbleSortT(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tempValue = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tempValue;
                }
            }
        }
        return arr;
    }

}
