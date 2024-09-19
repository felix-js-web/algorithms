// Principles of work
// 1) I do split the string by space into array off strings
// 2) Then is digit check is applied if not the only option can be
// it is a negative number or an ariphmetic action
// 3) After I know it is an ariphmetic action I do double pop and apply action
// after applying an action I push the result back to stack
// 4) After I know it is a number I just push it to stack as required
// 5) After all finished I just to Stack POP as request for result
//
//Correctness
//  1) Correctness provided by STACK data structure from Java
//  as of requirements logic fully suits PUSH and POP of LIFO stack
//
// Time Complexity
// every operation executed for O(1) as of push and pop are O(1) on stacks
//
// Space Complexity
// CASE 1 Worst Case O(n) we are using stack which will contain max n numbers
// CASE 2 BEST Case O(1) we are using stack which will contain max 2 numbers
// and the rest will be operations and then after stack is clear push the result
// of OPS and then new Number and OPS again which will make sure in BEST CASE it is O(1) only 2 objects are there


//https://contest.yandex.ru/contest/22781/run-report/118204372/
package sprint2finals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B {

//    Код: 43 -> Символ: +
//    Код: 42 -> Символ: *
//    Код: 45 -> Символ: -
//    Код: 47 -> Символ: /

    private final static int ADDITION = 43;
    private final static int MULTIPLICATION = 42;
    private final static int SUBTRACTION = 45;
    private final static int DIVISION = 47;
    private final static int NEGATE_SIGN = 45;

    public static void main(String args[]) throws IOException {
        Stack<Integer> actionStack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = reader.readLine();
            String[] actionsStrings = inputString.split(" ");
            for (int i = 0; i < actionsStrings.length; i++) {
                char action = actionsStrings[i].charAt(0);
                if (Character.isDigit(action) || (actionsStrings[i].length() > 1 && action == NEGATE_SIGN)) {
                    actionStack.push(Integer.valueOf(actionsStrings[i]));
                } else {
                    if (action == ADDITION) {
                        actionStack.push(actionStack.pop() + actionStack.pop());
                    }
                    if (action == SUBTRACTION) {
                        int divider = actionStack.pop();
                        int divisor = actionStack.pop();
                        actionStack.push(divisor - divider);
                    }
                    if (action == MULTIPLICATION) {
                        actionStack.push(actionStack.pop() * actionStack.pop());
                    }
                    if (action == DIVISION) {
                        int divider = actionStack.pop();
                        int divisor = actionStack.pop();
                        actionStack.push(Math.floorDiv(divisor, divider));
                    }
                }
            }
            System.out.println(actionStack.pop());
        }
    }
}