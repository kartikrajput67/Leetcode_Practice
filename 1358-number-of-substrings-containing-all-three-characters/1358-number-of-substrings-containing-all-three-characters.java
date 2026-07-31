class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[] lastSeen = {-1,-1,-1};
        // lastSeen = 

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            lastSeen[c-'a'] = i;

            int min = Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
            if(min != -1) ans += (min + 1);
        }
        return ans;
    }
}