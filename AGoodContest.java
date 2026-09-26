import java.util.Scanner;

/**
 * AGoodContest
 */
public class AGoodContest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int candidate = sc.nextInt();
            int arr[] = new int[3];
            for(int i = 0; i < 3; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(week_links(arr, candidate));
        }
        sc.close();
    }

    public static int week_links(int arr[], int candidate){
        int ans = Integer.MIN_VALUE;
        for(int a: arr){
            ans = Math.max(ans, candidate -a);
        }
        return ans;
    }
}