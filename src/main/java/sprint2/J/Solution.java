package sprint2.J;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class UnLimitedQueue {

    private final List<Integer> queueArray = new ArrayList<>();

    public void put(int v) {
        queueArray.add(v);
    }

    public void pop() {
        if (size() > 0) {
            System.out.println(queueArray.remove(0));
        } else {
            System.out.println("error");
        }
    }

    public int size() {
        //   System.out.println(tail - head);
        return queueArray.size();
    }

}

public class Solution {

    public static void main(String args[]) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCommands = 10;//Integer.parseInt(reader.readLine());
            UnLimitedQueue stackMax = new UnLimitedQueue();
//            String[] actionsStrings = new String[numberOfCommands];
//            for (int i = 0; i < numberOfCommands; i++) {
//                actionsStrings[i] = reader.readLine();
//            }
            String[] actionsStrings = {"put -34",
                    "put -23",
                    "get",
                    "size",
                    "get",
                    "size",
                    "push 1",
                    "get",
                    "get",
                    "put 80",
                    "size"
            };

            for (int i = 0; i < numberOfCommands; i++) {
                String action = actionsStrings[i];
                if (action.startsWith("size")) {
                    System.out.println(stackMax.size());
                }
                if (action.startsWith("get")) {
                    stackMax.pop();
                }
                if (action.startsWith("put")) {
                    stackMax.put(Integer.valueOf(action.replace("put ", "")));
                }
            }


        }
    }

}
