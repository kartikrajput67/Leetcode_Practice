class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n];
        return solve(s,0,0);
    }
    private boolean solve(String s, int i, int c){
        int n = s.length();
        //Base Case
        if(c < 0) return false;//spl case where close bracket more in start
        if(i == n) return c == 0;

        if(dp[i][c] != null) return dp[i][c];

        boolean isValid = false;
        if(s.charAt(i) == '(') isValid = solve(s, i+1, c+1);
        else if(s.charAt(i) == ')') isValid = solve(s, i+1, c-1);
        else{
            isValid = (solve(s, i+1, c+1) || solve(s, i+1, c-1) || solve(s, i+1, c));
        }
        return dp[i][c] = isValid;
    }
}