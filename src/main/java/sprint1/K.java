package sprint1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K {

    private static List<Integer> getSum(List<Integer> numberList, int k) {
        // Ваше решение
        var resultList = new ArrayList<Integer>();
        var sb = new StringBuilder();
        numberList.stream().mapToInt(i -> i).forEach(i -> sb.insert(0, i));
        var remainderSum = 0;
        var jString = sb.reverse().toString();
        var kString = String.valueOf(k);
        var jLength = jString.length() - 1;
        var kLength = kString.length() - 1;

        while (jLength >= 0 || kLength >= 0) {
            var sum = 0;
            if (jLength >= 0) {
                sum += Integer.valueOf(String.valueOf(jString.charAt(jLength)));
                jLength--;
            }
            if (kLength >= 0) {
                sum += Integer.valueOf(String.valueOf(kString.charAt(kLength)));
                kLength--;
            }
            if (remainderSum > 0) {
                sum++;
                remainderSum = 0;
            }
            if (sum >= 10) {
                remainderSum = 1;
                resultList.add(0,Integer.valueOf(String.valueOf(String.valueOf(sum).charAt(1))));
            } else {
                resultList.add(0,Integer.valueOf(String.valueOf(String.valueOf(sum).charAt(0))));
            }
        }
        if (remainderSum == 1) resultList.add(0, 1);
        return resultList;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
