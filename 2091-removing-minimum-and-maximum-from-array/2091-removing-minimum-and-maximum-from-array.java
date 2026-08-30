class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = -1, maxIdx = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > max) { max = nums[i]; maxIdx = i; }
            if(nums[i] < min) { min = nums[i]; minIdx = i; }
        }

        //3 cases are possible - 1:both del from front, 2:both del from end and 3: both del from opposite side

        //case 1 : both del from front
        int ans1 = Math.max(maxIdx, minIdx)+1;

        //case 2 : both del from end
        int ans2 = n - Math.min(maxIdx, minIdx);

        //case 3: both del from opposite side
        int ans3 = Math.min(maxIdx,minIdx)+1 + n-Math.max(maxIdx,minIdx);

        return Math.min(ans1, Math.min(ans2, ans3));

    }
}