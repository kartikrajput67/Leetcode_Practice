class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            int l = i+1, r = n-1;
            while(l < r){ // need 3 different ele
                int sum  = nums[i]+nums[l] + nums[r];

                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;r--;
                    //shrink l & r for differnt ele and remove duplicates
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(l < r && nums[r] == nums[r+1]) r--;
                }
                else if(sum <0) { // move to positive number
                    l++;
                }
                else r--;
            }
            while(i<n-2 && nums[i] == nums[i+1]) i++;
        }
        return ans;
    }
}