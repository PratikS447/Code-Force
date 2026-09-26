import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * BFashionableArray
 */
public class BFashionableArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            TreeMap<Integer, Integer> freq = new TreeMap<>(Collections.reverseOrder());
            for(int i = 0; i < N; i++){
                int x = sc.nextInt();
                freq.put(x, freq.getOrDefault(x, 0)+1);
            }

            List<Integer> a = new ArrayList<>();
            while (a.size() < N) {
                for(int key: freq.keySet()){
                    if(freq.get(key) > 0){
                        a.add(key);
                        freq.put(key, freq.getOrDefault(key, 0)-1);
                    }
                }
            }
            
            for(int x: a){
                System.out.print(x+" ");
            }
            
            System.out.println();
        }
        sc.close();
    }
}