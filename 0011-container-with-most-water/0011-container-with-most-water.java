class Solution {
    public int maxArea(int[] height) {
        //brute force - run two loop check for all i & j
        // optimal - use two pointer
        int n = height.length; 
        int left = 0, right  = n-1;
        int ans = 0;
        while(left < right){
            int water = Math.min(height[left],height[right]) * (right-left);
            ans = Math.max(ans,water);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }
}