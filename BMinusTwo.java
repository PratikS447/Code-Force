import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * BMinusTwo
 */
public class BMinusTwo {

    public static int max_Freq(int arr[]){
        int countOdd = 0, c0 = 0, c2 = 0;
        for(int a: arr){
            if ((a & 1) == 1) {
                countOdd++;
            }else if (a % 4 == 0) {
                c0++;
            }else{
                c2++;
            }
        }
        return Math.max(countOdd, Math.max(c0, c2));
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = sc.nextInt();
            }

            int ans = max_Freq(arr);
            System.out.println(ans);
            t--;
        }
        System.out.println();
    }
}