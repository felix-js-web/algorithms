package sprint4;

import java.util.Arrays;

public class YandexInsertionSort {

    public static void main(String args[]) {

        int[] arr = new int[]{945, 343, 1766, 1606, 1145, 41, 1509};
        int[] arrSorted = insertionSortToTheRightT(arr);

        Arrays.stream(arrSorted).forEach(value -> System.out.println(value));

    }

    public static int[] insertionSortToTheRightT(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int minimalValue = arr[i];
            while (j > 0 && minimalValue < arr[j-1] ){
                arr[j] = arr[j-1];
                arr[j-1] = minimalValue;
                j--;
            }
        }
        return arr;
    }

}
