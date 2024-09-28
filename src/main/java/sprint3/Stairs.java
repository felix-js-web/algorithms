package sprint3;

public class Stairs {

    public static void main(String[] args) {
        buildStairs(55);
    }

    private static void buildStairs(int n) {
        if (n >= 1) {
            System.out.println("Building out stair number " +n);
            buildStairs(n-1);
        } else
        {
            System.out.println("Built out the ladder");
            return;
        }
    }

}
