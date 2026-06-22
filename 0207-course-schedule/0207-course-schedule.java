class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //using kahn's algo it is very easy if cycle exists then those nodes never 
        //got 0 indegree so they will not add in queue and ans arrayList so ans.size()<numCourses
        
        //create an adjacency list with prerequisites
        ArrayList<Integer> [] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        //perform kahn's algorithm
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){//O(v+e) since it is directed so no any edge will be used twice
            for(int curr:graph[i]){
                indegree[curr]++;
            }
        }

         ArrayList<Integer> ans = new ArrayList<>();
        //initilize queue with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);

            for(int i:graph[curr]){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return (ans.size() == numCourses) ? true: false;
    }
}