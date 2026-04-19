class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        int j = m-1;
        for(int i=n-1; i>=0; ){
            if(j <= 0) return ans;
            else if(nums1[i] <= nums2[j]) ans = Math.max(j-(i--), ans);
            else{
                while(nums1[i] > nums2[j] && j>0) j--;
            }
        }
        return ans;
    }
}