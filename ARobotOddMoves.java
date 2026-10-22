import java.util.Scanner;

/**
 * ARobotOddMoves
 */
public class ARobotOddMoves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            long x = sc.nextLong();
            long y = sc.nextLong();

            if (y > x+1) {
                System.out.println(-1);
            }else{
                long parity = x%2;
                if (y%2 == parity) {
                    System.out.println(x);
                }else{
                    System.out.println(x+1);
                }
            }
        }
    }
}