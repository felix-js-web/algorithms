//https://contest.yandex.ru/contest/22450/run-report/117469684/
package sprint1finals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int arrayLength = readInt(reader);
            // to respond to your comment Valeriy
            // Why would they have the N in the input first of all - it is kind a weird parameter
            // which I always can obtain from Array or List length not sure
            // why it is needed to be input directly
            // So I kinda keeping it consistent -) not sure though if it is a right thing
            List<Integer> numberList = readList(reader);
            List<Integer> resultList = getClosestZeroDistances(numberList, arrayLength);
            for (int elem : resultList) {
                writer.write(elem + " ");
            }
        }
    }


    private static List<Integer> getClosestZeroDistances(List<Integer> numberList, int arrayLength) {
        int[] zeroCloseArray = new int[arrayLength];
        int counter = arrayLength;

        // Left to right pass
        // Slyamzil u copilot - chego to mozgi ustavshie bili - bolshe ne budu -)
        // No resheniye ponyal sam smog bi napisat bez problem spasibo za podskazku
        for (int i = 0; i < arrayLength; i++) {
            if (numberList.get(i) == 0) {
                counter = 0;
            } else {
                counter++;
            }
            zeroCloseArray[i] = counter;
        }

        // Right to left pass
        counter = arrayLength;
        for (int i = arrayLength - 1; i >= 0; i--) {
            if (numberList.get(i) == 0) {
                counter = 0;
            } else {
                counter++;
            }
            zeroCloseArray[i] = Math.min(zeroCloseArray[i], counter);
        }

        return Arrays.stream(zeroCloseArray)
                .boxed()
                .collect(Collectors.toList());
    }


    //Ostavlyayu vsegda starie resheniya v kommentah esli v
    // budushem budu gotovitsya k interview shtobi mog s nalizirovat uluchsheniya
    // Nadeyus vi ne protiv

//    private static List<Integer> getClosestZeroDistances(List<Integer> numberList, int arrayLength) {
//        int[] zeroCloseArray = new int[arrayLength];
//        var leftZeroIndex = -1;
//        for (int i = 0; i <= arrayLength - 1; i++) {
//            if (numberList.get(i) == 0) {
//                if (leftZeroIndex == -1) {
//                    recalculateDistancesFromTo(-1, i, zeroCloseArray, numberList);
//                    leftZeroIndex = i;
//                } else {
//                    recalculateDistancesFromTo(leftZeroIndex, i, zeroCloseArray, numberList);
//                    leftZeroIndex = i;
//                }
//            } else {
//                if (i == arrayLength - 1) {
//                    recalculateDistancesFromTo(leftZeroIndex, -1, zeroCloseArray, numberList);
//                }
//            }
//        }
//        //return list;
//        return Arrays.stream(zeroCloseArray)
//                .boxed()
//                .collect(Collectors.toList());
//    }
//
//    private static void recalculateDistancesFromTo(int from, int to, int[] zeroCloseArray, List<Integer> numberList) {
//        if (from == -1) {
//            for (int i = 0; i < to; i++) {
//                zeroCloseArray[i] = to - i;
//            }
//        } else if (to == -1) {
//            for (int i = from + 1; i <= numberList.size() - 1; i++) {
//                zeroCloseArray[i] = i - from;
//            }
//        } else {
//            for (int i = from + 1; i < to; i++) {
//                zeroCloseArray[i] = Math.min(i - from, to - i);
//            }
//        }
//    }

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
