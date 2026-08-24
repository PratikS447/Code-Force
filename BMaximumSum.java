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

    public static long findMaximumSum(long[] arr, int k){
        Arrays.sort(arr);
        long prefix[] = builderPrefixSum(arr);
        return computeMaxRemainingSum(arr, prefix, k);
    }

    private static long[] builderPrefixSum(long[] arr){
        int n = arr.length;
        long[] prefix = new long[n+1];
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i]+arr[i];
        }
        return prefix;
    }

    private static long computeMaxRemainingSum(long arr[], long[] prefix, int k){
        int n = arr.length;
        long totalSum = prefix[n];
        long answer = 0;

        for(int x = 0; x <= k; x++){
            int numberOfSmallest = 2*x;
            int numberOfLargest = k - x;

            if (numberOfSmallest > n) break;
            if (numberOfSmallest + numberOfLargest > n) continue;

            long smallestSum = prefix[numberOfSmallest];
            long largestSum = prefix[n] -prefix[n -numberOfLargest];
            long remainingSum = totalSum -smallestSum -largestSum;

            answer = Math.max(answer, remainingSum);
        }

        return answer;
    }
}