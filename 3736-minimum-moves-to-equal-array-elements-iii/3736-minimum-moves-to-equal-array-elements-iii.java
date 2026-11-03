class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int i=1; i<n; i++){
            max = Math.max(nums[i], max);
        }
        int ans = 0;
        for(int i: nums){
            ans += Math.abs(i-max);
        }
        return ans;
    }
}