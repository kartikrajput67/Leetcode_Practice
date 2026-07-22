class Solution {
    class Pair{
        int node,time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<times.length; i++){
            graph[times[i][0]].add(new Pair(times[i][1], times[i][2]));
        }

        int[] time = new int[n+1];
        for(int i=0; i<time.length; i++) time[i] = Integer.MAX_VALUE;
        time[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.time > time[curr.node]) continue;

            for(int i=0; i<graph[curr.node].size(); i++){
                Pair edge = graph[curr.node].get(i);
                int edgetime = curr.time+edge.time;

                if(edgetime < time[edge.node]){
                    time[edge.node] = edgetime;
                    pq.add(new Pair(edge.node, edgetime));
                }
            }
        }
        int maxTime = 0;
        for(int i=1; i<=n; i++){
            if(time[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime,time[i]);
        }
        return maxTime;
    }
}