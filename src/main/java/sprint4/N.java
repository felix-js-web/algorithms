package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Pairs {
    public Pairs(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int left;

    public int right;

    @Override
    public String toString() {
        return left + " " + right;
    }
}

public class N {

    public static void main(String[] args) throws IOException {
        int n = 0;
//        Pairs[] pairsArr;
        List<Pairs> pairsArr = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = readInt(reader);
//            n = 4;

            //pairsArr = new Pairs[n];

//            String stringsValue = "7 8\n" +
//                    "7 8\n" +
//                    "2 3\n" +
//                    "6 10";
//            // Split the string by newline characters to create an array of strings
//            String[] stringArray = stringsValue.split("\\n");
//            for (int i = 0; i < n; i++) {
//                List<Integer> pairsListInput = readList(stringArray[i]);
//                //pairsList.add(new Pairs(pairsListInput.get(0), pairsListInput.get(1)));
//                pairsArr.add(new Pairs(pairsListInput.get(0), pairsListInput.get(1)));
//            }

            for (int i = 0; i < n; i++) {
                List<Integer> pairsListInput = readList(reader);
                pairsArr.add(new Pairs(pairsListInput.get(0), pairsListInput.get(1)));
            }


            Comparator<Pairs> comparator = (pair1, pair2) -> {
                // First compare by the right field
                if (pair1.left != pair2.left) {
                    return Integer.compare(pair1.left, pair2.left);
                }
                // If the right fields are equal, compare by the left field
                return Integer.compare(pair1.right, pair2.right);
            };
//            insertion_sort_by_comparator(pairsArr, comparator);
            //Arrays.sort(pairsArr,comparator);
            pairsArr = quickSort(pairsArr, comparator);
            List<Pairs> resultPairs = new ArrayList<>();

            Pairs currentPair = null;
            for (int i = 0; i < n; i++) {
                Pairs newPair = pairsArr.get(i);
                if (currentPair == null) {
                    currentPair = newPair;
                    continue;
                }
                if (currentPair.right < newPair.left) {
//                    if (currentPair.left != newPair.left && currentPair.right >= newPair.right) {
//                        continue;
//                    }
                    resultPairs.add(currentPair);
                    currentPair = newPair;
                } else {
                    currentPair = new Pairs(Math.min(currentPair.left, newPair.left), Math.max(currentPair.right, newPair.right));
                }
            }
//            resultPairs = Arrays.asList(pairsArr);
            resultPairs.add(currentPair);
            resultPairs.forEach(System.out::println);

        }

    }

    private static List<Pairs> quickSort(List<Pairs> pairsArr, Comparator<Pairs> comparator) {
        if (pairsArr.size() < 2) return pairsArr;
        Random random = new Random();
        int pivot = random.nextInt(pairsArr.size());
        List<Pairs>[] parts = partition(pairsArr, pivot, comparator);
        return concatenate(quickSort(parts[0],comparator),parts[1],quickSort(parts[2],comparator));
    }

    private static List<Pairs>[] partition(List<Pairs> arrList, int pivot, Comparator<Pairs> comparator) {
        List<Pairs> a = new ArrayList<>();
        List<Pairs> b = new ArrayList<>();
        List<Pairs> c = new ArrayList<>();
        for (Pairs i : arrList) {
            if (comparator.compare(i, arrList.get(pivot )) < 0) {
                a.add(i);
            } else if (comparator.compare(i, arrList.get(pivot)) == 0) {
                b.add(i);
            } else {
                c.add(i);
            }
        }
        return new List[]{a, b, c};
    }


    private static List<Pairs> concatenate(List<Pairs> a, List<Pairs> b, List<Pairs> c) {
        List<Pairs> resultList = new ArrayList<>();
        resultList.addAll(a);
        resultList.addAll(b);
        resultList.addAll(c);
        return resultList;
    }

    // воспользуемся уже знакомой сортировкой вставками
    static void insertion_sort_by_comparator(Pairs[] array, Comparator<Pairs> less) {
        for (int i = 1; i < array.length; i++) {
            Pairs item_to_insert = array[i];
            int j = i;
            // заменим сравнение item_to_insert < array[j-1] на компаратор less
            while (j > 0 && less.compare(item_to_insert, array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = item_to_insert;
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static List<Integer> readList(String reader) throws IOException {
        return Arrays.asList(reader.split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}
