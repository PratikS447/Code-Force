import java.util.Scanner;

/**
 * ADiceRolling
 */
public class ADiceRolling {
    public static void main(String[] args) {
        int arr[] = new int[6];
        int cnt = 0;
        for(int i = 2; i <= 7; i++){
            arr[cnt] = i;
            cnt++;
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            if(N <= 7){
                System.out.println(1);
            }else{
                System.out.println((N+3)/4);
            }
        }
        sc.close();
    }
}