class Solution {
    class Pair{
        int x; 
        int y; 
        public Pair(int x, int y){
            this.x = x;
            this.y = y; 
        }
    }
    boolean[][] vis;
    public int countIslands(int[][] grid, int d) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] != 0 && !vis[i][j]){

                    vis[i][j] = true;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i,j));
                    
                    int[] dr = {0,-1,0,1};
                    int[] dc = {-1,0,1,0};

                    long sum = 0;
                    while(!q.isEmpty()){
                        Pair p = q.remove();
                        sum += grid[p.x][p.y];

                        for(int k=0; k<4; k++){
                            int nr = p.x+dr[k];
                            int nc = p.y+dc[k];

                            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                            if(grid[nr][nc] != 0 && !vis[nr][nc]){
                                vis[nr][nc] = true;
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