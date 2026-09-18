class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int dr[] = {0,-1,0,1};
        int dc[] = {-1,0,1,0};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean peak = true;
                for(int k=0; k<4; k++){
                    int row = i+dr[k];
                    int col = j+dc[k];
                    if(row >=0 && row <n && col>=0 && col<m && mat[i][j] < mat[row][col]) peak = false;
                }
                if(peak) return new int[] {i,j};
            }
        }
        return new int[] {-1,-1};
    }
}