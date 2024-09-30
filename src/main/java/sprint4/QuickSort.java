package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
            List<Integer> arrList = Arrays.asList(arr);
            System.out.println(quickSortMine(arrList));
        }
    }

    public static List<Integer> quickSortMine(List<Integer> arrList) {

        int n = arrList.size();
        if (n == 1 || n == 0) {
            return arrList;
        }

        int pivot = (arrList.get(0) + arrList.get(n - 1) + arrList.get(n / 2)) / 3;
        List<Integer>[] parts = partition(arrList, pivot);
        arrList = concatAllLists(quickSortMine(parts[0]), parts[1], quickSortMine(parts[2]));
        return arrList;
    }

    private static List<Integer> concatAllLists(List<Integer> leftPart, List<Integer> pivotPart, List<Integer> rightPart) {
        List<Integer> resultList = new ArrayList<>(leftPart.size() + pivotPart.size() + rightPart.size());
        resultList.addAll(leftPart);
        resultList.addAll(pivotPart);
        resultList.addAll(rightPart);
        return resultList;
    }

    private static List<Integer>[] partition(List<Integer> arrList, int pivot) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> pivotList = new ArrayList<>();
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) == pivot) {
                pivotList.add(arrList.get(i));
            } else if (arrList.get(i) < pivot) {
                leftList.add(arrList.get(i));
            } else {
                rightList.add(arrList.get(i));
            }
        }
        return new List[]{leftList, pivotList, rightList};
    }

}