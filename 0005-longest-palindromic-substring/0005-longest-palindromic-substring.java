class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i=0; i<n; i++){
            String odd = solve(s,i,i);
            String even = solve(s, i, i+1);

            if(odd.length() > even.length() && odd.length() > ans.length()) ans = odd;
            else if(even.length() > odd.length() && even.length() > ans.length()) ans = even;
        }
        return ans;
    }
    private String solve(String s, int l, int r){
        while(l>=0 && r<s.length()){
            if(s.charAt(l) != s.charAt(r)) break;
            l--;r++;
        }
        return s.substring(l+1,r);
    }
}