class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int s = 0, e = m-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            //find max int midth col
            int maxIdx = 0;
            for(int i=1; i<n; i++){
                if(mat[i][mid] > mat[maxIdx][mid]) maxIdx = i;
            }
            int left = (mid == 0)? -1: mat[maxIdx][mid-1];
            int right = (mid == m-1) ? -1 : mat[maxIdx][mid+1];
            if(mat[maxIdx][mid] > left && mat[maxIdx][mid] > right) return new int[] {maxIdx, mid};

            if(mat[maxIdx][mid] < left) e = mid-1;
            else s = mid+1;
        }
        return new int[] {-1,-1};
    }
}