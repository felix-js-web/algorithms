package org.example;

// Java

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] arr;
        List<Integer> result = new ArrayList<>();
        int n = 0;
        int K = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();
            //.collect(Collectors.toList());
            K = Integer.parseInt(reader.readLine().strip());
        }

//        Arrays.sort(arr);
//        int left = 0;
//        int right = n - 1;
//        while (left < right) {
//            if (arr[left] + arr[right] == K) {
//                result.add(arr[left]);
//                result.add(arr[right]);
//                break;
//            } else if (arr[left] + arr[right] > K) {
//                right--;
//            } else {
//                left++;
//            }
//        }

        Set<Integer> valueSet = new HashSet<>();

        int missingValue = 0;
        for (int i = 0 ; i < arr.length ; i++){
            missingValue = K - arr[i];
            if (valueSet.contains(missingValue)){
                result.add(missingValue);
                result.add(arr[i]);
                break;
            }
            else {
                valueSet.add(arr[i]);
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        if (result.size() > 0) {
            for (int i = 0; i < 2; i++) {
                writer.write(String.valueOf(result.get(i)));
                writer.write(" ");
            }
        } else {
            writer.write("None");
        }
        writer.flush();
    }

}
