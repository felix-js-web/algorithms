package sprint1;

import java.util.Scanner;

public class B {

    private static boolean checkParity(int a, int b, int c) {
        // Ваше решение
        int remA = a % 2;
        int remB = b % 2;
        int remC = c % 2;
        return Math.abs(remA) == Math.abs(remB) && Math.abs(remA) == Math.abs(remC) ;
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        if (checkParity(a, b, c)) {
        if (checkParity(-687373597 ,423392027 ,259465703)) {
            System.out.println("WIN");
        } else {
            System.out.println("FAIL");
        }
//        scanner.close();
    }

}