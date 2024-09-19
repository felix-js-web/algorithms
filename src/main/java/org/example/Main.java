package org.example;


// Java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
//        List<Integer> arr;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int n = Integer.parseInt(reader.readLine().strip());
//            arr = Arrays.asList(reader.readLine().strip().split(" "))
//                    .stream()
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//        }
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int i : arr) {
//            writer.write(String.valueOf(i));
//            writer.write(" ");
//        }
//        writer.flush();

        int[] visitors = {0, 2, 3, 2, 0, 4, 1, 1, 2};
        int[] entriesByVisitor = new int[5];
        int bestVisitor = 0;

        for (int i = 0; i < visitors.length; i++) {
            int visitor = visitors[i];
            entriesByVisitor[visitor]++;
            if (entriesByVisitor[visitor] > entriesByVisitor[bestVisitor]) {
                bestVisitor = visitor;
            }
        }

        System.out.println(bestVisitor);
    }

}