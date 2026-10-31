import java.util.Arrays;

class Solution {
    int[][][] dp;
    int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // dp[n][m][2]
        // 0 -> prevTurn was 'r'
        // 1 -> prevTurn was 'd'
        dp = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // shuru me man lete hain hum right (0) se enter kar rahe hain
        return solve(grid, 0, 0, 0);
    }

    private int solve(int[][] grid, int i, int j, int dir) {
        int n = grid.length;
        int m = grid[0].length;

        // 1. Boundary check
        if (i < 0 || i >= n || j < 0 || j >= m) return 0;

        // 2. Base case: destination reached
        if (i == n - 1 && j == m - 1) return 1;

        // 3. Memoized check
        if (dp[i][j][dir] != -1) return dp[i][j][dir];

        int ans = 0;

        // 4. Mirror case (grid[i][j] == 1)
        if (grid[i][j] == 1) {
            if (dir == 0) { // entered via 'r', bounce down ('d')
                ans = solve(grid, i + 1, j, 1);
            } else {        // entered via 'd', bounce right ('r')
                ans = solve(grid, i, j + 1, 0);
            }
        } 
        // 5. Normal empty cell (can move both right and down)
        else {
            int rightMove = solve(grid, i, j + 1, 0);
            int downMove = solve(grid, i + 1, j, 1);
            ans = (rightMove + downMove) % MOD;
        }

        // State ko cache karo
        return dp[i][j][dir] = ans;
    }
}