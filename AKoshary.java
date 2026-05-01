import java.util.Scanner;

public class AKoshary {
    public static boolean steps(int a, int b, int a_target, int b_target, int oneStepTaken){
        if(a == a_target && b == b_target){
            return true;
        }

        if(a > a_target || b > b_target){
            return false;
        }

        if(oneStepTaken > 1){
            return false;
        }

        // increament a coordinate by (a, b)
        if (steps(a + 2, b, a_target, b_target, oneStepTaken)) return true;
        if (steps(a, b + 2, a_target, b_target, oneStepTaken)) return true;

        if(oneStepTaken == 0){
            if(steps(a+1, b, a_target, b_target, 1)) return true;
            if(steps(a, b+1, a_target, b_target, 1)) return true;
        }

        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            // Assuming non-negative as per typical constraints
            if (a < 0 || b < 0) {
                System.out.println("NO");
                continue;
            }

            boolean possible = steps(0, 0, a, b, 0);
            if (possible) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}