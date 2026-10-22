import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BMaximumSum
 */
public class BMaximumSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int size = sc.nextInt();
            long arr[] = new long[size];
            int k = sc.nextInt();
            for(int i = 0; i < size; i++){
                arr[i] = sc.nextInt();
            }
            long res = findMaximumSum(arr, k);
            System.out.println(res);
            t--;
        }
        sc.close();
    }

    public static long findMaximumSum(long arr[], int k){
        Arrays.sort(arr);
        long prefix[] = build_Perfix(arr);
        return computeMaxRem(arr, prefix, k);
    }

    public static long[] build_Perfix(long arr[]){
        int n = arr.length;
        long prefix[] = new long[n+1];
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] +arr[i];
        }
        return prefix;
    }

    public static long computeMaxRem(long arr[], long prefix[], int k){
        int n = arr.length;
        long total_sum = prefix[n];
        long ans = 0;

        for(int x = 0; x <= k; x++){
            int numOfSmallest = 2*x;
            int numOfLargest = k -x;

            if (numOfSmallest > n) {
                break;
            }
            if (numOfSmallest + numOfLargest > n) {
                continue;
            }

            long smallest_sum = prefix[numOfSmallest];
            long larget_sum = prefix[n] -prefix[n -numOfLargest];
            long rem = total_sum -smallest_sum -larget_sum;

            ans = Math.max(ans, rem);
        }
        return ans;
    }
}