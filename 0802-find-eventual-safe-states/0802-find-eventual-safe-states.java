class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean pathvis[] = new boolean[v];
        boolean nocycle[] = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<v; i++){
            if(!vis[i]) dfs(i,graph,vis, pathvis, nocycle);
        }
        for(int i=0; i<v; i++){
            if(nocycle[i] == true) ans.add(i);
        }
        return ans;
    }
    private boolean dfs(int curr, int[][] graph, boolean[] vis, boolean[] pathvis, boolean[] nocycle){
        vis[curr] = true;
        pathvis[curr] = true;
        for(int i: graph[curr]){
            if(!vis[i]) {
                if(dfs(i,graph,vis, pathvis, nocycle)) return true;
            }
            else if(pathvis[i] == true) return true;
        }
        pathvis[curr] = false;
        nocycle[curr] = true;//no cycle for curr node
        return false;
    }
}