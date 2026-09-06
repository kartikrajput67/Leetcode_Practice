class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        //I use here two pointer i-indicate s chars & j-indicates t chars
        return solve(s,t,0,0);
    }
    private int solve(String s, String t,int i, int j){
        //Base Case
       
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        int totalSum  =0;
        //include
        if(s.charAt(i) == t.charAt(j)){
            int include = solve(s,t, i+1,j+1);
            int exclude = solve(s,t,i+1,j);
            totalSum = include+exclude;
        }
        else{
            totalSum = solve(s,t,i+1,j);
        }            
        return dp[i][j] =totalSum;
    }
}