package sprint2.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//
////TRIPLE STACK for any string and now it is can be for symmetric string only one stack is Enough there
//class StackMax {
//    private Stack<Character> sbStack = new Stack<>();
//    private Stack<Character> fbStack = new Stack<>();
//    private Stack<Character> cbStack = new Stack<>();
//
//    public StackMax() {
//        // do nothing for now
//    }
//
//    public String pushOrPopValuesAndReturnResult(String valueString) {
//        var returnBoolean = "True";
//        for (Character bracketSymbol : valueString.toCharArray()) {
//            if (bracketSymbol == '{') {
//                fbStack.push('{');
//            }
//            if (bracketSymbol == '[') {
//                sbStack.push('{');
//            }
//            if (bracketSymbol == '(') {
//                cbStack.push('{');
//            }
//            if (bracketSymbol == '}') {
//                if (fbStack.size() > 0) {
//                    fbStack.pop();
//                } else {
//                    return "False";
//                }
//            }
//            if (bracketSymbol == ']') {
//                if (sbStack.size() > 0) {
//                    sbStack.pop();
//                } else {
//                    return "False";
//                }
//            }
//            if (bracketSymbol == ')') {
//                if (cbStack.size() > 0) {
//                    cbStack.pop();
//                } else {
//                    return "False";
//                }
//            }
//        }
//        return (sbStack.size() == 0 && cbStack.size() == 0 && fbStack.size() == 0) ? "True" : "False";
//    }
//
//}

//Single Stack only one solution for symmetric String
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class StackMax {
    private Stack<Character> bracketsStack = new Stack<>();

    public StackMax() {
        // do nothing for now
    }

    public String pushOrPopValuesAndReturnResult(String valueString) {
        var returnBoolean = "True";
        for (Character bracketSymbol : valueString.toCharArray()) {
            if (bracketSymbol == '{') {
                bracketsStack.push('{');
            }
            if (bracketSymbol == '[') {
                bracketsStack.push('[');
            }
            if (bracketSymbol == '(') {
                bracketsStack.push('(');
            }
            if (bracketSymbol == '}') {
                if (bracketsStack.size() > 0) {
                    Character resultString = bracketsStack.pop();
                    if (!resultString.equals('{')) {
                        return "False";
                    }
                } else {
                    return "False";
                }
            }
            if (bracketSymbol == ')') {
                if (bracketsStack.size() > 0) {
                    Character resultString = bracketsStack.pop();
                    if (!resultString.equals('(')) {
                        return "False";
                    }
                } else {
                    return "False";
                }
            }
            if (bracketSymbol == ']') {
                if (bracketsStack.size() > 0) {
                    Character resultString = bracketsStack.pop();
                    if (!resultString.equals('[')) {
                        return "False";
                    }
                } else {
                    return "False";
                }
            }
        }
        return (bracketsStack.size() == 0) ? "True" : "False";
    }

}

public class Solution {

    public static void main(String args[]) throws IOException {
        StackMax stackMax = new StackMax();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String bracketsString = reader.readLine();
            System.out.println(stackMax.pushOrPopValuesAndReturnResult(bracketsString));
        }
    }

}