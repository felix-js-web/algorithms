package sprint4;

import java.util.Arrays;

public class SelSort {

    public static void main(String args[]) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
        int[] arr = new int[]{945, 343, 1766, 1606, 1145, 41, 1509};
        int[] arrSorted = selSort(arr);

        Arrays.stream(arrSorted).forEach(value -> System.out.println(value));
    }

    public static int[] selSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            if (minIndex != i){
                int tempValue = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tempValue;
            }
        }
        return arr;
    }
}
