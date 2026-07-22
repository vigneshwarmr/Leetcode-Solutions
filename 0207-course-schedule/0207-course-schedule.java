class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[]indegree= new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

       
        for(int []edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count =0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int nbr: adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        return count ==numCourses;
    }
}