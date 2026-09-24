class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(digitSum(nums[i]) == i) return i;
        }
        return -1;
    }
    private int digitSum(int n){
        int ans = 0;
        while(n > 0){
            int rem = n%10;;
            ans += rem;
            n/= 10;
        }
        return ans;
    }
}