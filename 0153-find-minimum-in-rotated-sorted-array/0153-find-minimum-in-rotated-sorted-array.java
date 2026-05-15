class Solution {
    public int findMin(int[] nums) {
        //Arr is sorted and rotated and its all elements are distinct.
        //so from middle one part is strictly sorted.

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int si = 0, ei = n-1;

        while(si <= ei){
            int mid = si + (ei-si)/2;
            //if left part is sorted
            if(nums[si] <= nums[mid]){
                min = Math.min(min, nums[si]);
                si = mid+1;
            }
            else{
                min = Math.min(min, nums[mid]);
                ei = mid-1;
            }
        }
        return min;
    }
}