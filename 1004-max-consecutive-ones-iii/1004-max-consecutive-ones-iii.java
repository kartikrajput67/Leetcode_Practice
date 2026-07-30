class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = 0, right = 0;
        int zeros = k;
        
        while(right < n){
            if(nums[right] == 0) zeros--;
            if(zeros < 0){
                if(nums[left] == 0) zeros++;
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right++;
            
        }
        
        return ans;
    }
}