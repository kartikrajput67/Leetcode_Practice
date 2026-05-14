class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int si = 0, ei = n-1;

        while(si <= ei){
            int mid = si + (ei-si)/2;
            if(nums[mid] == target) return mid;
        //mid ke ek side ka part sorted hoga compare krke si ya ei ko set kro
            
            if(nums[si] <= nums[mid]){//left of mid is sorted
                if(nums[si]<=target && target <= nums[mid]) ei = mid-1;//target is in range of left of mid part
                else si = mid+1;//target is in the right part
            }
            else if(nums[mid] <= nums[ei]){//right of mid is sorted
                if(nums[mid] <= target && target <= nums[ei]) si = mid+1;
                else ei = mid-1;
            }
        }
        return -1;
    }
}