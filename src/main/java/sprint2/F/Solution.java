package sprint2.F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StackMax {
    private List<Integer> valueList;

    public StackMax() {
        valueList = new ArrayList<>();
    }

    public void push(Integer v) {
        valueList.add(v);
    }

    public void pop() {
        if (valueList.size() > 0) {
            valueList.remove(valueList.size() - 1);
        } else {
            System.out.println("error");
        }
    }

    public Integer getMax() {
        return valueList.stream().max(Comparator.naturalOrder()).orElse(null);
    }

}

public class Solution {

    public static void main(String args[]) throws IOException {
        StackMax stackMax = new StackMax();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String action = reader.readLine();
                if (action.startsWith("pop")) {
                    stackMax.pop();
                }
                if (action.startsWith("get_max")) {
                    Integer getMaxResult = stackMax.getMax();
                    if (getMaxResult == null) {
                        System.out.println("None");
                    } else {
                        System.out.println(getMaxResult);
                    }
                }
                if (action.startsWith("push")) {
                    stackMax.push(Integer.valueOf(action.replace("push ", "")));
                }
            }


        }
    }

}
