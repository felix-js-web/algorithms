package sprint4.KK;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”
        int[] leftArr = Arrays.copyOfRange(arr, left, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, right);
        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”

        if (right - left < 2) {
            return;
        }

        int mid = (right + left) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);

        // Сливаем отсортированные части
        merge(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}