package sprint2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import java.io.IOException;

public class A {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int rowCount = 4;//readInt(reader);
//            int columnCount = 3;//readInt(reader);
            int rowCount = readInt(reader);
            int columnCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowCount, columnCount);
//            List<List<Integer>> reversedMatrix = reverseMatrix(matrix, rowCount, columnCount);
//            for (List<Integer> element : reversedMatrix) {
//                for (int elem : element) {
//                    System.out.print(elem + " ");
//                }
//                System.out.println();
//            }
            for (int j = 0; j < columnCount; j++) {
                for (int i = 0; i < rowCount; i++) {
                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

//    private static List<List<Integer>> reverseMatrix(List<List<Integer>> matrix, int rowCount, int columnCount) {
//
//        for (int j = 0; j < columnCount; j++) {
//            for (int i = 0; i < rowCount; i++) {
//                System.out.print(matrix.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//
//        return matrix;
//
//    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<Integer> readListFromString(String reader) throws IOException {
        return Arrays.asList(reader.split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowCount, int columnCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowCount);
//        String[] array = new String[]{"1 2 3", "0 2 6", "7 4 1", "2 7 0"};
        for (int i = 0; i < rowCount; i++) {
            matrix.add(readList(reader));
//            matrix.add(readListFromString(array[i]));
        }
        return matrix;
    }

}
