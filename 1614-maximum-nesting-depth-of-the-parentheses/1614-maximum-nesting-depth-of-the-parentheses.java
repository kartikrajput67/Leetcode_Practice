class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '(') {
                count++;
                ans = Math.max(count, ans);
            }else if(c == ')') count--;
        }
        return ans;
    }
}