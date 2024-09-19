package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomeClassDebug {

    public static void main(String[] args) {
        Pair<List<Integer>, int[]> pair2 = getLeastPrimesLinear(5);
        System.out.println("FINISHED");
    }


    public static Pair<List<Integer>, int[]> getLeastPrimesLinear(int n) {
        int[] lp = new int[n + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes.add(i);
            }
            for (int j = 0; j < primes.size(); j++) {
                int p = primes.get(j);
                int x = p * i;
                if (p > lp[i] || x > n) {
                    break;
                }
                lp[x] = p;
            }
        }
        return new Pair<>(primes, lp);
    }
}

class Pair<T, T1> {
    public T primes;
    public T1 lp;

    public Pair(T primes, T1 lp) {
        this.primes = primes;
        this.lp = lp;
    }
}
