class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i=0; i<n ;i++){
            for(int j=0; j<m;j++){
                if(grid[i][j] == 1){
                    //track the ith row for any server to communicate
                    boolean communication = false;
                    for(int k=0; k<n ;k++){
                        if(grid[k][j] == 1 && k != i){
                            count++;
                            communication = true;
                            break;
                        }
                    }
                    //track the jth col for any server to communicate
                    if(!communication){
                        for(int k=0; k<m ;k++){
                            if(grid[i][k] == 1 && k != j){
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}