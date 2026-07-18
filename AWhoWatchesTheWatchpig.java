import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class AWhoWatchesTheWatchpig {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read number of test cases
        String firstLine = br.readLine();
        if (firstLine == null) return;
        st = new StringTokenizer(firstLine);
        int t = Integer.parseInt(st.nextToken());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();

            // Delegate calculation to the modular solver method
            int result = getMinFlips(n, k, s);
            output.append(result).append("\n");
        }
        
        System.out.print(output);
    }


    public static int getMinFlips(int n, int k, String s) {
        // If the required prefix (k 'R's) and suffix (k 'L's) overlap, it is impossible.
        if (2 * k > n) {
            return -1;
        }

        int flips = 0;

        // Count flips needed to ensure the first k characters are 'R'
        flips += countMismatches(s, 0, k, 'R');

        // Count flips needed to ensure the last k characters are 'L'
        flips += countMismatches(s, n - k, n, 'L');

        return flips;
    }

    /**
     * Helper method to count how many characters in a specific range 
     * do not match the target character.
     */
    private static int countMismatches(String s, int start, int end, char target) {
        int mismatches = 0;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) != target) {
                mismatches++;
            }
        }
        return mismatches;
    }
}