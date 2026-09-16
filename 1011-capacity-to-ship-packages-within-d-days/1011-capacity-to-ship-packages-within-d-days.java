class Solution {
    private int max(int[] nums){
        int ans = nums[0];
        for(int i:nums){
            ans = Math.max(ans,i);
        }
        return ans;
    }
    private int sum(int[] nums){
        int ans = 0;
        for(int i:nums){
            ans += i;
        }
        return ans;
    }

    private int days(int[] nums, int n){
        int days = 1, cnt  =0;
        for(int i: nums){
            cnt += i;
            if(cnt > n){
                days++;
                cnt = i;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        int l = max(weights), r = sum(weights);
        while(l <= r){
            int mid = l+(r-l)/2;
            if(days(weights,mid) <= days){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}