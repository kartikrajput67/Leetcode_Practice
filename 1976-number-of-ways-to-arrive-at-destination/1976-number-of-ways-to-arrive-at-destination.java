class Solution {
     class Pair{
        int node;
        long time;
        Pair(int node, long time){
            this.node = node;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<roads.length; i++){
            graph[roads[i][0]].add(new Pair(roads[i][1], roads[i][2]));
            graph[roads[i][1]].add(new Pair(roads[i][0], roads[i][2]));
        }

        long[] time = new long[n];
        for(int i=0; i<time.length; i++) time[i] = Long.MAX_VALUE;
        time[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new Pair(0,0));

        int MOD = 1000000007;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.time > time[curr.node]) continue;

            for(int i=0; i<graph[curr.node].size(); i++){
                Pair edge = graph[curr.node].get(i);
                long edgetime = curr.time+edge.time;

                if(edgetime < time[edge.node]){
                    time[edge.node] = edgetime;
                    ways[edge.node] = ways[curr.node];
                    pq.add(new Pair(edge.node, edgetime));
                }
                else if(edgetime == time[edge.node]){
                    ways[edge.node] = (ways[edge.node] + ways[curr.node]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}