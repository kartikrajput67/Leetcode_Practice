class Solution {
    int [][] dp = new int[501][501];
    private int solve(int[] piles, int i, int j){
        if(i>j) return 0;
        if(i == j) return piles[i];

        if(dp[i][j] != -1) return dp[i][j];

        //choose left
        int take_i = piles[i] - solve(piles,i+1, j);
        
        //choose right
        int take_j = piles[j] - solve(piles, i, j-1);

        return dp[i][j] = Math.max(take_i, take_j);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        
        return solve(piles,0,n-1) > 0;
    }
}