class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean pathvis[] = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<v; i++){
            if(!vis[i]) dfs(i,graph,vis, pathvis, ans);
        }
        Collections.sort(ans);
        return ans;
    }
    private boolean dfs(int curr, int[][] graph, boolean[] vis, boolean[] pathvis, ArrayList<Integer> ans){
        vis[curr] = true;
        pathvis[curr] = true;
        for(int i: graph[curr]){
            if(!vis[i]) {
                if(dfs(i,graph,vis, pathvis, ans)) return true;
            }
            else if(pathvis[i] == true) return true;
        }
        pathvis[curr] = false;
        ans.add(curr);
        return false;
    }
}