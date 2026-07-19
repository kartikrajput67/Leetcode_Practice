class Solution {
    class Pair{
        int r,c,effort;
        Pair(int r, int c, int eff){
            this.r = r;
            this.c =c;
            effort = eff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        //arr to calculate effort
        int[][] arr = new int[n][m];
        for (int[] row : arr) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        arr[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.effort,b.effort));
        pq.add(new Pair(0,0,0));

        //valid directions
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int r = curr.r;
            int c = curr.c;
            if(curr.effort > arr[r][c]) continue;
            if(r == n-1 && c == m-1) return curr.effort;
            
            //traverse all valid directions
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                int newEffort = Math.max(curr.effort, 
                Math.abs(heights[r][c] - heights[nr][nc]));
                if(newEffort < arr[nr][nc]){
                    pq.add(new Pair(nr,nc,newEffort));
                    arr[nr][nc] = newEffort;
                }
            }
        }
        return arr[n-1][m-1];
    }
}