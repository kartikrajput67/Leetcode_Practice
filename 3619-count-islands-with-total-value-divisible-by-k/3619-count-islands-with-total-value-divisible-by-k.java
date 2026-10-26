class Solution {
    class Pair{
        int x; 
        int y; 
        public Pair(int x, int y){
            this.x = x;
            this.y = y; 
        }
    }
    public int countIslands(int[][] grid, int d) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] != 0){
                    long sum = grid[i][j];
                    grid[i][j] = 0;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i,j));
                    
                    int[] dr = {0,-1,0,1};
                    int[] dc = {-1,0,1,0};

                    
                    while(!q.isEmpty()){
                        Pair p = q.remove();
                        

                        for(int k=0; k<4; k++){
                            int nr = p.x+dr[k];
                            int nc = p.y+dc[k];

                            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                            if(grid[nr][nc] != 0){
                                sum += grid[nr][nc];
                                grid[nr][nc] = 0;

                                q.add(new Pair(nr,nc));
                            }
                        }
                    }
                    if(sum % d == 0) ans++;
                }
            }
        }
        return ans;
    }
}