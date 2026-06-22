class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            long sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum % 10 == x){
                    long temp = sum;
                    while(temp >= 10){
                        temp /= 10;
                    }
                    if(temp ==x) ans++;
                }
            }
        }
        return ans;
    }
}