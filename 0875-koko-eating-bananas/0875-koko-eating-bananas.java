class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if(n == h) return max(piles);

        int si = 1,ei = max(piles);
        int ans = Integer.MAX_VALUE;
        while(si <= ei){
            int mid = si + (ei-si)/2;
            long finishT = finishTime(piles,mid);

            if(finishT > h) si = mid+1;
            else {
                ans = Math.min(ans,mid);
                ei = mid-1;
            }
        }
        return ans;
    }
    private long finishTime(int[] piles, int k){
        long totalTime = 0;
        for(int i: piles){
            if(i%k == 0) totalTime += i/k;
            else totalTime += (i/k)+1;
        }
        return totalTime;
    }
    private int max(int[] piles){
        int max = 0;
        for(int i:piles) max = Math.max(i,max);
        return max;
    }
}