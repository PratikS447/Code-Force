import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ABoredom
 */
public class ABoredom {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[100005];
        
        int max = 0;
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            arr[val] += val; 
            max = Math.max(max, val);
        }
        long dp[] = new long[max+1];
        Arrays.fill(dp, -1);
        long val = helper(arr, max, dp);
        System.out.println(val);
        sc.close();
    }

    public static long helper(long arr[], int val, long dp[]){
        if (val <= 0) {
            return 0;
        }

        if (dp[val] != -1) {
            return dp[val];
        }

        long choose = arr[val]+ helper(arr, val-2, dp);
        long not_choose = helper(arr, val-1, dp);

        return dp[val] = Math.max(choose, not_choose);
    }
}