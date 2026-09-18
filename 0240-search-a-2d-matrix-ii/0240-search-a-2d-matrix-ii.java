class Solution {
    private boolean BinSearch(int [] arr, int n){
        int l = 0, r = arr.length-1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(arr[mid] == n) return true;
            if(arr[mid] > n) r = mid-1;
            else l = mid+1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0; i<n; i++){
            //check is target can fit in this row 
            if(matrix[i][0] <= target && target <= matrix[i][m-1]){
                if(BinSearch(matrix[i],target)) return true;
            }
        }
        return false;
    }
}