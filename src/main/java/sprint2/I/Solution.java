package sprint2.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class LimitedQueue {

    private int maxSizeNumber;
    private final List<Integer> queueArray = new ArrayList<>();
    private int head = 0;
    private int tail = 0;

    public LimitedQueue(int queueSize) {
        maxSizeNumber = queueSize;
    }

    public void push(int v) {
        if (tail <= maxSizeNumber - 1) {
            queueArray.add(v);
            tail++;
        } else {
            System.out.println("error");
        }
    }

    public void pop() {
        if (tail <= maxSizeNumber && tail > 0) {
            System.out.println(queueArray.get(0));
            queueArray.remove(0);
            tail--;
        } else {
            System.out.println("None");
        }
    }

    public void peek() {
        if (size() > 0) {
            System.out.println(queueArray.get(0));
        } else {
            System.out.println("None");
        }
    }

    public void printSize() {
        System.out.println(tail);
    }

    public int size() {
        //   System.out.println(tail - head);
        return tail;
    }

}

public class Solution {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCommands = Integer.parseInt(reader.readLine());
            int queueSize = Integer.parseInt(reader.readLine());
            LimitedQueue stackMax = new LimitedQueue(queueSize);
            String[] actionsStrings = new String[numberOfCommands];
            for (int i = 0; i < numberOfCommands; i++) {
                actionsStrings[i] = reader.readLine();
            }
//            String[] actionsStrings = {"push 1",
//                    "size",
//                    "push 3",
//                    "size",
//                    "push 1",
//                    "pop",
//                    "push 1",
//                    "pop",
//                    "push 3",
//                    "push 3"};

            for (int i = 0; i < numberOfCommands; i++) {
                String action = actionsStrings[i];
                if (action.startsWith("size")) {
                    stackMax.printSize();
                }
                if (action.startsWith("peek")) {
                    stackMax.peek();
                }
                if (action.startsWith("pop")) {
                    stackMax.pop();
                }
                if (action.startsWith("push")) {
                    stackMax.push(Integer.valueOf(action.replace("push ", "")));
                }
            }


        }
    }

}
