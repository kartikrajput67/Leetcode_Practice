class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            int odd = solve(s,i,i);
            int even = solve(s, i, i+1);

            ans += odd + even;
        }
        return ans;
    }
    private int solve(String s, int l, int r){
        int count  =0 ;
        while(l>=0 && r<s.length()){
            if(s.charAt(l) != s.charAt(r)) break;
            count++;
            l--;r++;
        }
        return count;
    }
}