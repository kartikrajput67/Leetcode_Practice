class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else {
                count--;
                if(count >= 1) sb.append(c);
                continue;
            }
            if(count >=2) sb.append(c);
        }
        return sb.toString();
    }
}