class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);

        int count = 1,ans = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]-1 == nums[i-1])count++;
            else {
                ans = Math.max(ans,count);
                count = 1;
            }
        }
        return Math.max(ans,count);
    }
}