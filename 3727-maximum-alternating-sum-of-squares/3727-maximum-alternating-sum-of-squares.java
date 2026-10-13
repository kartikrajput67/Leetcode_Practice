class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long pos = 0;
        long neg = 0;
        int posLen = 0;
        if(n % 2 == 0) posLen = n/2;
        else posLen = n/2+1;

        int i=0, j = n-1;
        while(posLen > 0){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                pos += nums[i]*nums[i]; i++; posLen--;
            }
            else{
                pos+= nums[j]*nums[j]; j--; posLen--;
            }
        }

        for( ; i<=j; i++){
            neg += nums[i]*nums[i];
        }

        return pos-neg;
    }
}