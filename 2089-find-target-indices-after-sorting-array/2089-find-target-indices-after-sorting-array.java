class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        // List<Integer> ans = new ArrayList<>();
        // for(int i=0; i<nums.length; i++){
        //     if(target == nums[i]) ans.add(i);
        // }
        // return ans;

        int n = nums.length;
        int smallerCount = 0, targetFreq = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < target) smallerCount++;
            else if(nums[i] == target) targetFreq++;
        }

        List<Integer> ans = new ArrayList<>();
        int i=smallerCount;
        while(targetFreq > 0){
            ans.add(i);i++;
            targetFreq--;
        }
        return ans;
    }
}