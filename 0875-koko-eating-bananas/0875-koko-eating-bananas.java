class Solution {
    private int max(int[] piles){
        int ans = piles[0];
        for(int i:piles){
            ans = Math.max(ans, i);
        }
        return  ans;
    }
    private long finish(int n, int[] piles){
        long ans = 0;
        for(int i : piles){
            ans += (i%n == 0)? i/n : i/n + 1;
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = max(piles);
        int ans = max(piles);
        while(l<=r){
            int mid = l+(r-l)/2;
            long finishHours = finish(mid,piles);
            if(finishHours <= h){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}