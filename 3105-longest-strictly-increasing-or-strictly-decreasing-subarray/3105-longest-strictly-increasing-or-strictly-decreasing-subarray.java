class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n-1; i++){
            int dec=0, inc = 0;
            for(int j=i+1; j<n; j++){
                if(nums[j-1] > nums[j] && inc==0){
                    dec++;
                }
                else if(nums[j-1] < nums[j] && dec==0){
                    inc++;
                }
                else break;
            }
            ans = Math.max(ans,Math.max(inc,dec));
        }
        return ans+1;
    }
}