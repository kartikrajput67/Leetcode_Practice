class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[] {-1,-1};
        int[] ans = new int[2];
        //ceil is first index and floor is last index of an element

        //ceil - jb tk nums[mid] >= target , then e = mid-1
        int s = 0, e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid] >= target) e=mid-1;
            else s = mid+1;
        }
        ans[0] = (s<n && nums[s] == target) ? s: -1;

        //floor - jb tk nums[mid] <= target then s = mid+1
        s =0;
        e = n-1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(nums[mid] <= target) s = mid+1;
            else e = mid-1;
        }
        ans[1] = (e>=0 && nums[e] == target) ? e: -1;
        return ans;
    }
}