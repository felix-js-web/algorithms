package sprint3;

public class BinaryRecursion {

    public static void main(String args[]) {
        System.out.println(getBinaryDigits(-6));
    }

    private static String getBinaryDigits(int n) {
        String lastDigit = Integer.toString(n % 2);
        if (n < 0) {
            return "-" + getBinaryDigits(-n);
        }
        if (n!=0) {
            return getBinaryDigits(n / 2) + lastDigit;
        } else {
            return "";
        }
    }

}
