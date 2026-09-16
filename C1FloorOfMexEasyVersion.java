import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * C1FloorOfMexEasyVersion
 */
public class C1FloorOfMexEasyVersion {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = null;

        String line = br.readLine();
        if(line == null) return ;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if(l == null) return ;
                st = new StringTokenizer(l);
            }
            int n = Integer.parseInt(st.nextToken());
            int a[] = new int[n+1];

            for(int i = 1; i <= n; i++){
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Start with all elements from 0 to n-1
            TreeSet<Integer> B = new TreeSet<>();
            for(int i = 0; i < n; i++){
                B.add(i);
            }

            // For each k, remove any element y where floor(y / k) == a[k]
            for(int k = 1; k <= n; k++){
                int target = a[k];
                int start = target * k;
                int end = Math.min(n - 1, (target + 1) * k - 1);

                for(int y = start; y <= end; y++){
                    B.remove(y);
                }
            }

            out.println(B.size());
            StringBuilder sb = new StringBuilder();
            for(int x: B){
                sb.append(x).append(" ");
            }
            out.println(sb.toString().trim());
        }
        out.flush();
    }
}