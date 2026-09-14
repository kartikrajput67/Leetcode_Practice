class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=  nums.length;
        int l = 0, r = n-1;
        while(l<=r){
            if(l == r) return nums[l];
            int mid = l+(r-l)/2;
            //mid is unique
            if(mid == n-1 && nums[mid] != nums[mid-1]) return nums[mid]; 
             if(mid == 0 && nums[mid] != nums[mid+1]) return nums[mid]; 
            if(nums[mid]!=nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];

            if(nums[mid-1] == nums[mid]){
                if(mid%2 == 0) r = mid-1;
                else l = mid+1;
            }
            else if(nums[mid+1] == nums[mid]){
                if(mid%2 == 0) l = mid+1;
                else r = mid-1;
            }

        }
        return -1;
    }
}