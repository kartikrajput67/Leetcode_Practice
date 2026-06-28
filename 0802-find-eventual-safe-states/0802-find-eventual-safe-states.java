class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //make a reverse graph of this graph to find terminal or '0' indegree nodes
        int V = graph.length;
        ArrayList<Integer>[] graphRev = new ArrayList[graph.length];
        for(int i=0; i<V; i++){
            graphRev[i] = new ArrayList<>();
        }
        //reverse process
        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].length; j++){
                graphRev[graph[i][j]].add(i);
            }
        }
        //perform topo sort on terminal nodes(0 indegree nodes)
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int curr: graphRev[i]){
                indegree[curr]++;
            }
        }

        //bfs process using queue
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<V; i++){
            System.out.println(indegree[i]);
            if(indegree[i] == 0) q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            //remove adjacent to find more terminal nodes
            for(int i: graphRev[curr]){
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}