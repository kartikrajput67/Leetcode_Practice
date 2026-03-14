class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int suff = 1;
        int pref = 1;
        int res[] = new int[n];

        //prefix store in res
        for(int i=0; i<n; i++){
            res[i] = pref;
            pref *= nums[i];
        }

        //multiply suffix in res
        for(int i=n-1; i>=0; i--){
            res[i] *= suff;
            suff *= nums[i];
        }
        return res;
    }
}