package sprint4;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
        int[] arrSorted = sortArrayInsertionSortI(arr);

        Arrays.stream(arrSorted).forEach(value -> System.out.println(value));
    }

    public static int[] sortArrayInsertionSortI(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int minValue = arr[i];
            int minValueIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= minValue) {
                    break;
                } else {
                    minValueIndex = j;
                }
            }
            if (minValueIndex != i){
                swapElementsFromIToJ(i, minValueIndex, arr);
            }
        }
        return arr;
    }

    private static void swapElementsFromIToJ(int rightI, int leftJ, int[] arr) {
        for (int i = rightI ; i >= leftJ+1; i--){
            int tempValue = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = tempValue;
        }
    }

}
