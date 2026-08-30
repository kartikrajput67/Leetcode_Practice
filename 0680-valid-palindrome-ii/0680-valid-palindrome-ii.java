class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){ //can delete any one l or r
                if(palindrome(s,l+1,r) || palindrome(s,l,r-1)) return true;
                else return false;
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean palindrome(String s, int l, int r){
        while(l< r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}