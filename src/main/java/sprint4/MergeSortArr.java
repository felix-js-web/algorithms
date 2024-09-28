package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSortArr {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
            System.out.println(Arrays.toString(mergeSortMine(arr)));
        }
    }

    private static int[] mergeSortMine(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        int[] left = mergeSortMine(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] right = mergeSortMine(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        int[] resultArr = new int[arr.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                resultArr[k] = left[i];
                i++;
            } else {
                resultArr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            resultArr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            resultArr[k] = right[j];
            j++;
            k++;
        }
        return resultArr;
    }

}