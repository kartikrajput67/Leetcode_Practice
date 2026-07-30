class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            int zeros=k;//we can flip at most 2 zeros for each substring

            for(int j=i; j<n; j++){
                if(nums[j] == 0) zeros--;
                if(zeros < 0) break;
                ans = Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}