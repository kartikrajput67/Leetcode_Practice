class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //max days = when 1 wt ship daily = sum of weights array
        //min days = 1 = ship all weights(sum of weights array)

        int low = Arrays.stream(weights).max().getAsInt(), high = sum(weights);

        // for(int i=low; i<= high; i++){
        //     if(totalDays(weights,i) <= days) return i;
        // }
        // return -1;

        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(totalDays(weights,mid) <= days){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    private int totalDays(int[] weights, int k){
        int days = 1,sum = 0;
        for(int i:weights){
            sum += i;
            if(sum > k){
                days++;
                sum = i;
            }
        }
        return days;
    }
    private int sum(int[] weights){
        int sum = 0;
        for(int i:weights) {
            sum += i;
        }
        return sum;
    }
}