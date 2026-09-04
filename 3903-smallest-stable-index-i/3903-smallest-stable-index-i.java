class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int ans = -1;
        for(int i=0; i<n; i++){
            int max = maxi(nums,i);
            int min = mini(nums,i);
            if(max - min <= k )return i;
        }
        return ans;
    }
    private int maxi(int[] nums, int i){
        int max = nums[0];
        for(int j=1; j<=i; j++){
            max = Math.max(max, nums[j]);
        }
        return max;
    }
    private int mini(int[] nums, int i){
        int min = nums[i];
        for(int j=i+1; j<nums.length; j++){
            min = Math.min(min, nums[j]);
        }
        return min;
    }
    
}