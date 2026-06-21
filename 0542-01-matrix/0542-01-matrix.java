class Solution {
    class Pair{
        int r;
        int c;
        int dis;
        Pair(int r, int c, int dis){
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        //make a visited array which track the element vis or not
        boolean[][] vis = new boolean[n][m];

        //here choose bfs because its asking nearest distance
        Queue<Pair> q = new LinkedList<>();

        //initially store all zeros position in queue
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0) {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        //now extract zeroes and check neighbours if 1 then perform operati
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        
        while(!q.isEmpty()){
            Pair curr = q.remove();
            
            for(int i=0; i<4; i++){
                int nr = curr.r+dr[i];
                int nc = curr.c+dc[i];
                if(nr<0 || nr>=n || nc<0 || nc>=m || vis[nr][nc]) continue;
                //if neighbour is 1 and not visited
                if(mat[nr][nc] == 1){
                    vis[nr][nc] = true;
                    mat[nr][nc] = curr.dis+1;
                    q.add(new Pair(nr,nc,curr.dis+1));
                }
            }
            
        }
        return mat;
    }
}