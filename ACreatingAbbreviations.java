import java.util.*;

/**
 * ACreatingAbbreviations
 */
public class ACreatingAbbreviations {

    public static boolean isPossible(String str[], String abbre[]){
        Set<Character> set = new HashSet<>();
        for(String s: str){
            set.add((char)(s.charAt(0)-32));
        }
        for(String s: abbre){
            for(Character c: s.toCharArray()){
                if (!set.contains(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0){
            int input_str = sc.nextInt();
            int abbre_str = sc.nextInt();

            sc.nextLine();

            String str[] = new String[input_str];
            for(int i = 0; i < input_str; i++){
                str[i] = sc.nextLine();
            }

            String abb_arr[] = new String[abbre_str];
            for(int i = 0; i < abbre_str; i++){
                abb_arr[i] = sc.nextLine();
            }

            if(isPossible(str, abb_arr)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            t--;
        }

        System.out.println();
        sc.close();
    }
}