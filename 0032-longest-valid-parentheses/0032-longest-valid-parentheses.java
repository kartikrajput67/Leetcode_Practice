class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        int open = 0, close = 0;

        //left to right traversal
        for(char c: s.toCharArray()){
            if(c == '(') open++;
            else{
                close++;
                
                if(close > open) {
                    open = 0;
                    close = 0;
                }
                else if(open == close){
                    ans = Math.max(ans, close+open);
                }
            }
        }
        //right to left traversal for some cases where open reamins like "(()"
        open = 0; close = 0;
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == ')') close++;
            else{
                open++;
                
                if(open > close) {
                    open = 0;
                    close = 0;
                }
                else if(open == close){
                    ans = Math.max(ans, close+open);
                }
            }
        }
        return ans;
    }
}