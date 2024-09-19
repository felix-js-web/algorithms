package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class H {
    private static String sumOfBinaries(String a, String b) {
        // Ваше решение
//        return getBinaryNumber(getNumberFromBinary(a)+getNumberFromBinary(b));
        var sb = new StringBuilder();
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        var aLength = a.length() - 1;
        var bLength = b.length() - 1;
        var carrySum = 0;
        var sum = 0;
        while (aLength >= 0 || bLength >= 0) {
            sum = 0;
            if (aLength >= 0) {
                sum += a.charAt(aLength) == '0' ? 0 : 1;
                aLength--;
            }
            if (bLength >= 0) {
                sum += b.charAt(bLength) == '0' ? 0 : 1;
                bLength--;
            }
            sum += carrySum;
            if (sum == 0)
                sb.insert(0, '0');
            if (sum == 1) {
                sb.insert(0, '1');
                carrySum = 0;
            }
            if (sum == 2) {
                sb.insert(0, '0');
                carrySum = 1;
            }
            if (sum == 3) {
                sb.insert(0, '1');
                carrySum = 1;
            }
        }
        if (carrySum == 1) sb.insert(0, "1");
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();
            System.out.println(sumOfBinaries(a, b));
        }
    }

}
