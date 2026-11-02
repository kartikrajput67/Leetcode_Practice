class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        // int max = nums[0],min = nums[0];
        Arrays.sort(nums);
        int mid = nums[n/2];
        // for(int i: nums){
        //     if(i<min) min = i;
        //     else if(i>max) max = i;
        // }

        // int mid = (min+max)/2;
        //mid ke equal kro sbko
        int ans = 0;
        for(int i:nums){
            ans+= Math.abs(i-mid);
        }
        return ans;
    }
}