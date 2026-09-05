import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * AMooLanguageSchool
 */
public class AMooLanguageSchool {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine().trim();

            sb.append(solve(n, k, s)).append('\n');
        }

        System.out.print(sb);
    }

    private static int solve(int n, int k, String s){
        int ans = 0;
        for(int start = 0; start < n; start += k){
            boolean hasFree = false;
            for(int i = start; i < start +k; i++){
                if(s.charAt(i) == '0'){
                    hasFree = true;
                    break;
                }
            }
            if (!hasFree) {
                ans++;
            }
        }
        return ans;
    }
}