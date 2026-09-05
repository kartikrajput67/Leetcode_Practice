class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l =0, r = 0;
        HashSet<Character> set = new HashSet<>();

        int ans = 0;
        while(r < n){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}