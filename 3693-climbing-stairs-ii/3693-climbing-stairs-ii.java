class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int cost = Integer.MAX_VALUE;
            int j = i-1;
            cost = costs[i-1]+1 + dp[j];

            j = i-2;
            if(j >= 0){
                cost = Math.min(cost,costs[i-1]+ 4 + dp[j]);
            }

             j = i-3;
            if(j>=0)
            cost = Math.min(cost,costs[i-1]+ 9 + dp[j]);
            dp[i] = cost;
        }
        return dp[n];
        // return solve(n,costs);
    }
    // private int solve(int n, int[] costs){
    //     if(n == 0) return 0;
    //     if(dp[n]!=0) return dp[n];
    //     int ans = solve(n-1,costs)+1+costs[n-1];
    //     if(n>=2) ans = Math.min(ans,solve(n-2,costs)+4+costs[n-1]);
    //     if(n>=3) ans = Math.min(ans,solve(n-3, costs)+9+costs[n-1]);
    //     return dp[n] = ans;
    // }
}