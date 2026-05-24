class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1, high = Arrays.stream(nums).max().getAsInt();

        // for(int i=low; i<= high; i++){
        //     int sum = sumOfCeil(nums,i);
        //     if(sum <= threshold) return i;
        // }
        //return -1;//false return or unreachable

        //optimize
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(sumOfCeil(nums,mid) <= threshold){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    private int sumOfCeil(int[] nums, int n){
        int sum = 0;
        for(int i:nums){
            sum += (i+n-1)/n;//ceil formula
        }
        return sum;
    }
}