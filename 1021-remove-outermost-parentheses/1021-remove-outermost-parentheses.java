class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
                if(open>1) sb.append('('); 
            }else{
                open--;
                if(open>0) sb.append(')');
            }
        }
        return sb.toString();
    }
}