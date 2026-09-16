import java.util.Scanner;

public class BMinMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            // 1. Feasibility check:
            // The number of unique row/column minimums (k) must be between n and 2n - 1.
            if (k < n || k >= 2 * n) {
                System.out.println("-1");
                continue;
            }
            
            int[][] matrix = new int[n][n];
            boolean[] used = new boolean[n + 1];
            
            // 2. Place extra elements in the first row:
            // To increase the count of unique minimums beyond n, we place specific numbers 
            // (starting from 2) in the first row.
            int extraElements = k - n;
            for (int i = 0; i < extraElements; i++) {
                matrix[0][i + 1] = i + 2; // e.g., places 2, 3, 4... in row 0
                used[i + 2] = true;       // Mark these numbers as used
            }
            
            // 3. Place remaining numbers (1 to n) on the diagonal:
            // Any number from 1 to n that hasn't been used yet is placed on the main diagonal.
            for (int num = 1; num <= n; num++) {
                if (!used[num]) {
                    for (int r = 0; r < n; r++) {
                        if (r >= 1 && r <= extraElements) continue;
                        if (matrix[r][r] == 0) {
                            matrix[r][r] = num;
                            break;
                        }
                    }
                }
            }
            
            // 4. Fill the rest of the matrix:
            // Fill all remaining empty cells (0s) sequentially with numbers from (n + 1) to (n^2).
            int nextValue = n + 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = nextValue++;
                    }
                }
            }
            
            // 5. Print the resulting matrix:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + (j == n - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}