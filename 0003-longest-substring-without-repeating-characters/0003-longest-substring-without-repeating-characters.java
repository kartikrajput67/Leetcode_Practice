class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxSize = 0;
        int left = 0, right = 0;
        
        HashSet<Character> set = new HashSet<>();
        // set.add
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxSize = Math.max(maxSize, set.size());
        }
        return maxSize;
    }
}