class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            boolean greater = false;
            for(int j=(i+1)%n; j!=i; j = (j+1)%n){
                if(nums[j] > nums[i]){
                    greater = true;
                    ans[i] = nums[j];
                    break;
                }
            }
            if(!greater) ans[i] = -1;
        }
        return ans;
    }
}