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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;
       
        //create distance array to map distance
        int[][] dis = new int[n][n];
        for(int i=0;i <n; i++){
            for(int j=0; j<n;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[0][0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.dis,b.dis));
        pq.add(new Pair(0,0,1));

        //valid moves
        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,1,1,1,0,-1,-1,-1};

        //update distance until pq is not empty
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int currRow = p.r;
            int currCol = p.c;
            int currDis = p.dis;

            //check valid indexes
            for(int i=0; i<8; i++){
                int nextRow = currRow+dr[i];
                int nextCol = currCol+dc[i];
                if(nextRow < 0 || nextRow>=n || nextCol < 0 || nextCol >= n) continue;
                if(grid[nextRow][nextCol] == 0 && currDis + 1 < dis[nextRow][nextCol]) {
                    dis[nextRow][nextCol] = currDis+1;
                    pq.add(new Pair(nextRow, nextCol, currDis+1));
                }
            }
        }

        if(dis[n-1][n-1] == Integer.MAX_VALUE) return -1;
        return dis[n-1][n-1];
    }
}