class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        int j = 0;
        int ans = Integer.MAX_VALUE;
        int currSum = 0;

        for(int i=0; i<n; i++){
            currSum += arr[i];
            while(currSum > target){
                currSum -= arr[j++];
            }
            best[i] = (i == 0) ? INF: best[i-1];
            if(currSum == target){
                int len = i-j+1;
                if(j>0 && best[j-1] != INF){
                    ans = Math.min(ans,len+best[j-1]);
                }
                best[i] = Math.min(best[i], len);
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}