class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // if(n == 1) return s;
        String ans=Character.toString(s.charAt(0));
        for(int i=0; i<n-1 ;i++){
            for(int j=i+1; j<n; j++){
                if(palindrome(s,i,j) && ans.length() < j-i+1){
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
    private boolean palindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}