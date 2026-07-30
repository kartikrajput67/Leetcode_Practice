class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0;
        for(int i=0; i<k; i++){
            lsum += cardPoints[i];
        }

        int maxSum = lsum;
        int rsum = 0;
        int rIndex = n-1;
        for(int i=k-1; i>=0; i--){//k time left se remove and right se add 
            lsum -= cardPoints[i];
            rsum += cardPoints[rIndex--];
            maxSum = Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
}