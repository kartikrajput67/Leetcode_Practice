class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0; i<n; i++){
            for(int val: matrix[i]){
                if(val == target) return true;
            }
        }
        return false;
    }
}