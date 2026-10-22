import java.util.Arrays;
import java.util.Scanner;

/**
 * ACutRibbon
 */
public class ACutRibbon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        int val = helper(n, a, b, c, memo);
        System.out.println(val);
        sc.close();
    }

    public static int helper(int n, int a, int b, int c, int memo[]){
        if (n == 0) { // perfectly cut the ribbon
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int takeA = helper(n-a, a, b, c, memo);
        int takeB = helper(n-b, a, b, c, memo);
        int takeC = helper(n-c, a, b, c, memo);

        int maxPiece = Math.max(takeA, Math.max(takeB, takeC));

        return memo[n] = (maxPiece == Integer.MIN_VALUE) ? Integer.MIN_VALUE : maxPiece+1;
    }
}