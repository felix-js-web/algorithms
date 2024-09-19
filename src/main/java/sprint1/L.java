package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class L {

    private static char getExcessiveLetter(String s, String t) {
        // Ваше решение
        var sum = 0;
        var sLength = s.length() - 1;
        var tLength = t.length() - 1;

        while (tLength >= 0 || sLength >= 0) {
            if (tLength >= 0) {
                sum ^= t.charAt(tLength--);
            }
            if (sLength >= 0) {
                sum ^= s.charAt(sLength--);
            }
        }

        return (char) sum;
//        var hashMap = new HashMap<Character,Integer>();
//        for (int i = 0; i < t.length(); i++) {
////            System.out.println(t.charAt(i));
//            hashMap.compute(t.charAt(i), (key, value) -> (value == null) ? 1 : value+1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            hashMap.compute(s.charAt(i), (key, value) -> value-1);
//        }
//        hashMap.entrySet().parallelStream()
//                .filter(entry -> entry.getValue()>0)
//                .findAny().get().getKey();
//
//        return hashMap.entrySet().parallelStream()
//                .filter(entry -> entry.getValue()>0)
//                .findAny().get().getKey();

//        var sum = 0;
//        var sLength = s.length() - 1;
//        var tLength = t.length() - 1;
//
//        while (tLength>=0 || sLength >=0){
//            if (tLength>=0){
//                sum+= t.charAt(tLength--);
//            }
//            if (sLength>=0){
//                sum-= s.charAt(sLength--);
//            }
//        }
//
//        return (char) sum;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(getExcessiveLetter(s, t));

        }
//        System.out.println(getExcessiveLetter("go", "ogg"));
    }
}