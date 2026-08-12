class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i=0, j = 0;
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            while(map.get(nums[j]) > k){
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}