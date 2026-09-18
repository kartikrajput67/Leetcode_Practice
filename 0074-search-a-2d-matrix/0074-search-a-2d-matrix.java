class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int s = 0, e = m*n-1;
        while(s <= e){
            int mid = s + (e-s)/2;
            int i = mid/m;//do a dry run with 1st example to know this basic math
            int j = mid%m;
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) e = mid-1;
            else s = mid+1;
        }
        return false;
    }
}