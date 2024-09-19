package sprint2.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class StackMax {
    private Stack<Integer> valueStack = new Stack<>();
    private Stack<Integer> topValueStack = new Stack<>();

    private Integer maxNumber;

    public StackMax() {
        // do nothing for now
    }

    public void push(Integer v) {
        valueStack.push(v);
        if (maxNumber == null) {
            maxNumber = v;
        } else {
            if (v > maxNumber) {
                maxNumber = v;
            }
        }
        topValueStack.push(maxNumber);
    }

    public void pop() {
        if (valueStack.size() > 0) {
            valueStack.pop();
            topValueStack.pop();
            if (topValueStack.size() > 0) {
                maxNumber = topValueStack.peek();
            } else {
                maxNumber = null;
            }
        } else {
            System.out.println("error");
        }
    }

    public void top() {
        System.out.println(valueStack.size() > 0 ? valueStack.peek() : "error");
    }

    public void getMax() {
        System.out.println(maxNumber == null ? "None" : String.valueOf(maxNumber));
    }

}

public class Solution {

    public static void main(String args[]) throws IOException {
        StackMax stackMax = new StackMax();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String[] actionsStrings = new String[n];
            for (int i = 0; i < n; i++) {
                actionsStrings[i] = reader.readLine();
            }
//            String[] actionsStrings = {"pop",
//                    "pop",
//                    "top",
//                    "push 4",
//                    "push -5",
//                    "top",
//                    "push 7",
//                    "pop",
//                    "pop",
//                    "get_max",
//                    "top",
//                    "pop",
//                    "get_max"};

            for (int i = 0; i < n; i++) {
                String action = actionsStrings[i];
                if (action.startsWith("pop")) {
                    stackMax.pop();
                }
                if (action.startsWith("get_max")) {
                    stackMax.getMax();
                }
                if (action.startsWith("top")) {
                    stackMax.top();
                }
                if (action.startsWith("push")) {
                    stackMax.push(Integer.valueOf(action.replace("push ", "")));
                }
            }
        }
    }
}
