class Solution {
    int [][] dp = new int[501][501];
    private int solve(int[] piles, int i, int j){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j]; 

        int take_i = piles[i] + Math.min(solve(piles,i+2,j), solve(piles,i+1,j-1));
        
        int take_j = piles[j] + Math.min(solve(piles,i+1, j-1),solve(piles,i,j-2));

        return dp[i][j] = Math.max(take_i, take_j);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }

        int alice_score = solve(piles,0,n-1);
        int totalSum = 0;
        for(int i:piles) totalSum += i;
        int bob_score = totalSum - alice_score;
        return alice_score > bob_score;
    }
}