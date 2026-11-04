class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]) {
                if(HasPath(graph,vis,s,d)) return true;
            }
        }
        return false;
    }
    private boolean HasPath(ArrayList<Integer>[] graph, boolean[] vis, int curr, int d){
        if(curr == d) return true;
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            int des = graph[curr].get(i);
            if(!vis[des]) if(HasPath(graph,vis,des,d)) return true;
        }
        return false;
    }
}