class Solution {

    class Pair {
        int r, c, dis;

        Pair(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        //since all weights are equal so it can be solved using bfs-TC-O(n^2)
        //whereas the dijkstra's takes as TC- O(n^2 * log n)-so only use when different weights
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][n];

        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;

        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,1,1,1,0,-1,-1,-1};

        while (!q.isEmpty()) {

            Pair curr = q.remove();

            // Destination reached
            if (curr.r == n - 1 && curr.c == n - 1)
                return curr.dis;

            for (int i = 0; i < 8; i++) {

                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (grid[nr][nc] == 0 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc, curr.dis + 1));
                }
            }
        }

        return -1;
    }
}