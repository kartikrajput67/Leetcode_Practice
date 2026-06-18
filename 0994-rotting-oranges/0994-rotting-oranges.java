class Solution {
    class Pair{
        int r;
        int c;
        int time;
        Pair(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,time));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                    vis[i][j] = 1;
                }
            }
        }
        //neighbours in all 4 sides
        int[] dr = {0,1,0,-1};//start from left
        int[] dc = {-1,0,1,0};//start from left
        while(!q.isEmpty()){
            Pair p = q.remove();
            //process 4 neighbours
            
            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                //if next position is a fresh orange
                if(nr>-1 && nr<n && nc>-1 && nc<m && 
                    vis[nr][nc] == 1){
                        vis[nr][nc] = 2;
                        time = Math.max(time,p.time+1);
                        q.add(new Pair(nr,nc,p.time+1));
                        fresh--;
                }
            }
        }
        return (fresh == 0)? time: -1;
    }
}