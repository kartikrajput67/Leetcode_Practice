class Solution {
    class Pair {
        int stops;
        int node;
        int cost;
    Pair(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //create graph with flights
        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        } 
        for(int i=0; i<flights.length; i++){
            int srce = flights[i][0];
            int des = flights[i][1];
            int cost = flights[i][2];
            graph[srce].add(new Pair(0,des,cost));
        }

        //cost array to calculate cost
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]  = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,src,0));

        //dijkstra's algo
        while(!q.isEmpty()){
            Pair curr = q.remove();
            // if(curr.cost > cost[curr.node]) continue;
            if(curr.stops > k) continue;

            //visit neighbours/adjacents
            for(int i=0; i<graph[curr.node].size(); i++){
                Pair edge = graph[curr.node].get(i);
                int newCost = curr.cost+edge.cost;
                //relaxation
                if(cost[edge.node] > newCost){
                    cost[edge.node] = newCost;
                    q.add(new Pair(curr.stops+1, edge.node, newCost));
                }
            }
        }
        for(int i: cost) System.out.print(i+" ");
        if(cost[dst] == Integer.MAX_VALUE) return -1;
        return cost[dst];
    }
}