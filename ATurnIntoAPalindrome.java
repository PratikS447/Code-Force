import java.util.Scanner;

/**
 * ATurnIntoAPalindrome
 */
public class ATurnIntoAPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int num = sc.nextInt();
            Character ch = sc.next().charAt(0);
            String str = sc.next();

            int res = isPalindrom(str, 0, ch);

            System.out.println(res);   
        }
        sc.close();
    }

    public static int isPalindrom(String str, int num, char ch){
        int i = 0;
        int j = str.length() -1;
        int cnt = 0;
        while (i < j) {
            if(str.charAt(i) != str.charAt(j)){
                if(ch != str.charAt(i) && ch != str.charAt(j)){
                    cnt = cnt+2;
                }else if(ch != str.charAt(i) && ch == str.charAt(i)){
                    cnt = cnt+1;
                }else{
                    cnt = cnt+1;
                }
            }
            i++; j--;
        }
        return cnt;
    }
}