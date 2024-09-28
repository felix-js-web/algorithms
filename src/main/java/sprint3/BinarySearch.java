package sprint3;

import java.util.Arrays;

public class BinarySearch {


    public static void main(String[] args) {
        int[] sortedArray = {5,10,12,13,14};
        Arrays.sort(sortedArray);
        System.out.println(binarySearch(sortedArray, 1, 0, sortedArray.length));
//        System.out.println(findInSortedArray(sortedArray, 1, 0, sortedArray.length));
    }

    public static int binarySearch(int[] arr, int x, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        // промежуток не пуст
        int mid = (left + right) / 2;
        if (arr[mid] == x) {  // центральный элемент — искомый
            return mid;
        } else if (x < arr[mid]) { // искомый элемент меньше центрального значит следует искать в левой половине
            return binarySearch(arr, x, left, mid);
        } else { // иначе следует искать в правой половине
            return binarySearch(arr, x, mid + 1, right);
        }
    }

//    public static int findInSortedArray(int[] sortedArray, int soughtNumber, int left, int right) {
//        if (right <= left) {
//            if (sortedArray[right] == soughtNumber) {
//                return right;
//            }
//            return -1;
//        }
//        var middle = (left + right) / 2;
//        if (sortedArray[middle] == soughtNumber) {
//            return middle;
//        } else if (soughtNumber < sortedArray[middle]) {
//            return findInSortedArray(sortedArray, soughtNumber, 0, middle);
//        } else {
//            return findInSortedArray(sortedArray, soughtNumber, middle + 1, right);
//        }
//    }

}
