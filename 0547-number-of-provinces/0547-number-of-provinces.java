class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[i].length; j++){
                if(isConnected[i][j] == 1) graph[i].add(j);
            }
        }

        //call for all components(provinces)
        int countProvinces = 0;
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                countProvinces++;
                dfs(graph, vis, i);
            }
        }
        return countProvinces;
    }

    private void dfs(ArrayList<Integer> [] graph, boolean[] vis, int curr){
        vis[curr] = true;
        for(int i: graph[curr]){
            if(!vis[i]) dfs(graph,vis,i);
        }
    }
}