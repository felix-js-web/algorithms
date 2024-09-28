package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class D {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfChildren = Integer.parseInt(reader.readLine());
            List<Integer> childrenGreedinessList = readList(reader);
            int numberOfBisquits = Integer.parseInt(reader.readLine());
            List<Integer> bisquitSizeList = readList(reader);
            System.out.println(checkHowManyWillBeHappy(numberOfChildren, childrenGreedinessList, numberOfBisquits, bisquitSizeList));
        }
    }

    private static int checkHowManyWillBeHappy(int numberOfChildren, List<Integer> childrenGreedinessList, int numberOfBisquits, List<Integer> bisquitSizeList) {
        Collections.sort(childrenGreedinessList);
        Collections.sort(bisquitSizeList);
        int numberOfHappyChildren = 0;
        int i = 0;
        int j = 0;
        while (i < childrenGreedinessList.size() && j < bisquitSizeList.size()) {
            int childrenGreedy = -1;
            if (i < childrenGreedinessList.size()) {
                childrenGreedy = childrenGreedinessList.get(i);
                i++;
            }
            int bisquitSize = -1;
            if (j < bisquitSizeList.size()) {
                bisquitSize = bisquitSizeList.get(j);
                j++;
            }
            if (bisquitSize != -1 && childrenGreedy != -1) {
                if (bisquitSize >= childrenGreedy) {
                    numberOfHappyChildren++;
                } else {
                    i--;
                }
            }
        }
        return numberOfHappyChildren;
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<Integer> readList(String valuesString) throws IOException {
        return Arrays.asList(valuesString.split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}