import java.util.Arrays;
import java.util.Scanner;

/**
 * AZeroSum
 */
public class AZeroSum {

    public static boolean isPossible(int arr[], int n){
        int sum = Arrays.stream(arr).sum();
        if(sum % 4 == 0){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            if(isPossible(arr, n)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        System.out.println();
    }
}