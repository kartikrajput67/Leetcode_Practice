class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = nums.length;

        //create adjacency list to calculate depth
        ArrayList<Integer> [] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            adj[parent[i]].add(i);
        }

        //traverse using bfs/dfs to calculate depth
        int [] depth = new int[n];
        depth[0] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int ht = 0;
        while(!q.isEmpty()){
            int curr  = q.remove();
            ht = Math.max(ht, depth[curr]);
            for(int i: adj[curr]){
                depth[i] = depth[curr]+1;
                q.add(i);
            }
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            ans += (long)nums[i] * (ht - depth[i] + 1);
        }
        return ans;
    }
}