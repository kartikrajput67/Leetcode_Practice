class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[n];
        int idx = -1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(nums1[i] == nums2[j]){
                    boolean greater = false;
                    for(int k=j+1; k<m; k++){
                        if(nums2[k] > nums2[j]){
                            ans[++idx] = nums2[k];
                            greater = true;
                            break;
                        }
                    }
                    if(!greater){
                         ans[++idx] = -1;
                         break;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}