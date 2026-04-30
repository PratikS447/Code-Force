import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AYoungPhysicist {
    public static String younPhysicist(List<List<Integer>> ans, int n){
        for(int i = 0; i < 3; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum = sum + ans.get(j).get(i);
            }
            if(sum != 0){
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        for(int j = 0; j < n; j++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            ans.add(new ArrayList<>(Arrays.asList(x, y, z)));
        }
        String str = younPhysicist(ans, n);
        System.out.print(str);
    }
}
