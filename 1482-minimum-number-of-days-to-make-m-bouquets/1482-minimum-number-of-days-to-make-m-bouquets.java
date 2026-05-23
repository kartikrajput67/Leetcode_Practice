class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;
        int low = 1, high = max(bloomDay);

        // for(int day=low; day<=high; day++){
        //     if(possibleBouquets(bloomDay,k,day) >= m) return day;
        // }
        // return -1;

        //binary search
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            int count = possibleBouquets(bloomDay, k, mid);
            if(count >= m){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    private int max(int[] arr){
        int max = 0;
        for(int i:arr){
            max = Math.max(max, i);
        }
        return max;
    }
    private int possibleBouquets(int[] bloomDay, int k,int day){
        int bouquets = 0;
        int adjFlowers = 0;
        for(int i:bloomDay){
            if(i <= day){
                adjFlowers++;
                if(adjFlowers >= k){
                    bouquets++;
                    adjFlowers = 0;
                }
            }
            else adjFlowers = 0;

        }
        return bouquets;
    }
}