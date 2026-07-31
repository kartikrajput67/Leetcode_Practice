class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int i=1;
        int ans = 0;

        while(n>8){
            ans += 8*i;
            i++;
            n -= 8;
        }
        ans += n*i;
        return ans;
    }
}