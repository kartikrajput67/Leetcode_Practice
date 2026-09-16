class Solution {
    private int max(int[] nums){
        int ans = nums[0];
        for(int i:nums){
            ans = Math.max(ans,i);
        }
        return ans;
    }

    private int divisorSum(int[] nums, int n){
        int ans = 0;
        for(int i:nums){
            ans += (i+n-1)/n;
        }
        return ans;
    }
    public int smallestDivisor(int[] nums, int t) {
        int ans = 0;
        int l = 1, r = max(nums);
        while(l <= r){
            int mid = l + (r-l)/2;
            if(divisorSum(nums,mid) <= t){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}