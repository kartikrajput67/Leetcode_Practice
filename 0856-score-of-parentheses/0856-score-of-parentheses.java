class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int count = 0;
        int depth = 0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(') {
                depth++;
            }
            else{
                depth--;
                if(s.charAt(i-1) == '('){
                    count += Math.pow(2,depth);
                }
            }
        }
        return count;
    }
}