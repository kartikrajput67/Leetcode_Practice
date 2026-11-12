class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        return solve(n,costs);
    }
    private int solve(int n, int[] costs){
        if(n == 0) return 0;
        if(dp[n]!=0) return dp[n];
        int ans = solve(n-1,costs)+1+costs[n-1];
        if(n>=2) ans = Math.min(ans,solve(n-2,costs)+4+costs[n-1]);
        if(n>=3) ans = Math.min(ans,solve(n-3, costs)+9+costs[n-1]);
        return dp[n] = ans;
    }
}