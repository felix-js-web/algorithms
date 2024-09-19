package sprint1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class F {

    private static boolean isPalindrome(String text) {
        // Ваше решение
        if (text == null) {
            return false;
        }

        if (text.length() == 1) {
            return true;
        }
//        //SOLUTION 1
//        var newText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
//        var StringBuilder = new StringBuilder(newText);
//        var newTextReversed = StringBuilder.reverse().toString().toLowerCase();
//        if (newText.equals(newTextReversed)) {
//            return true;
//        } else {
//            return false;
//        }
//        //SOLUTION 2
//        var newText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
//        var textLen = newText.length();
//        var returnValue = true;
//        for (int i = 0; i < textLen / 2; i++) {
//            if (newText.charAt(i) != newText.charAt(textLen - 1 - i)) {
//                return false;
//            }
//        }
//        return returnValue;
        //SOLUTION3
        var newText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        var right = newText.length() - 1;
        var left = 0;

        var returnValue = true;
        while (left < right) {
            if (newText.charAt(left) != newText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return returnValue;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            if (isPalindrome(text)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}