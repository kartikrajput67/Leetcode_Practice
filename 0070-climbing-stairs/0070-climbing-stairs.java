class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        return solve(n);
    }
    private int solve(int n){
        if(n == 0) return 1;
        if(dp[n] != 0) return dp[n];
        int step1 = solve(n-1);
        int step2 = 0;
        if(n>=2) step2 = solve(n-2);
        return dp[n] = step1+step2;
    }
}