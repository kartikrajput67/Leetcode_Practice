class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int si = 0, ei = n - 1;

        while (si <= ei) {
            if(si == ei) return nums[si];
            int mid = si + (ei - si) / 2;
            
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];//mid is that single ele

            else if ((ei - mid) % 2 == 0) { //all side even no of elements of mid
                if (nums[mid] == nums[mid - 1])
                    ei = mid;
                else
                    si = mid;
            } else { //all side odd no of elements of mid
                if(nums[mid] != nums[mid-1]) ei = mid-1;
                else si = mid+1;
            }
        }
        return 0;
    }
}