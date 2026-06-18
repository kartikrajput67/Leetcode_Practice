class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dfs(image,sr, sc, color);
        return image;
    }
    private void dfs(int[][] image,int sr, int sc, int color){
        int n = image.length;
        int m = image[0].length;

        //fill color to sr,sc index
        int startingPixel = image[sr][sc];
        image[sr][sc] = color;

        //call for neighbours/adjacents
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int i=0; i<4; i++){
            int nr = sr+dr[i];
            int nc = sc + dc[i];
            if(nr>-1 && nr<n && nc>-1 && nc<m && image[nr][nc] == startingPixel){
                dfs(image, nr, nc, color);
            }
        }
    }
}