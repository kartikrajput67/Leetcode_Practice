class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //using bfs method - as the topo sort add 0 indegree element in queue and then pop ele one by one and remove adjacent nodes with it to found more 0 indegree element

        //make a graph with prerequisites
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int j:graph[i]){
                indegree[j]++;
            }
        }

        //write topo sort algo using queue
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];

        //perform bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int i:graph[curr]){
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
            }
        }
        Collections.reverse(ans);
        if(ans.size() < numCourses) return new int[] {};
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}