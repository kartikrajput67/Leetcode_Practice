class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for(int i=1; i<=arr[n-1] ; i++){
            boolean found = false;
            for(int j=0; j<n; j++){
                if(arr[j] == i) found = true;
            }
            if(!found) k--;
            if(k == 0) return i;
        }
        return arr[n-1]+k;
    }
}