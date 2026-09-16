import java.util.Scanner;
import java.util.Stack;

/**
 * AMinMaxGame
 */
public class AMinMaxGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            if(chooses(arr)){
               System.out.println("Bessie"); 
            }else{
                System.out.println("Elsie");
            }
        }
    }

    public static boolean chooses(int arr[]){
        int n = arr.length;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                cnt++;
            }
        }

        if(2*cnt >= n){
            return true;
        }

        return false;
    }
}