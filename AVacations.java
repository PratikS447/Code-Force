import java.util.Arrays;
import java.util.Scanner;

/**
 * AVacations
 */
public class AVacations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        } 
        int memo[][] = new int[N][4];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        int min = helper(0, 3, N, arr, memo);
        System.out.println(min);
    }

    private static int helper(int day, int lastActivity, int n, int a[], int memo[][]){
        if (day == n) {
            return 0;
        }

        if (memo[day][lastActivity] != -1) {
            return memo[day][lastActivity];
        }

        int minRest = 1 + helper(day +1, 0, n, a, memo);

        if ((a[day] == 1 || a[day] == 3) && lastActivity != 1) {
            minRest = Math.min(minRest, helper(day+1, 1, n, a, memo));
        }

        if ((a[day] == 2 || a[day] == 3) && lastActivity != 2) {
            minRest = Math.min(minRest, helper(day+1, 2, n, a, memo));
        }

        return memo[day][lastActivity] = minRest;
    }
}