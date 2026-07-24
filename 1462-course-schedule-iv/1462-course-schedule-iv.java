class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[]indegree = new int[numCourses];
        for(int[]edge:prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        

        boolean[][]pre = new boolean[numCourses][numCourses];

        while(!q.isEmpty()){
            int node =q.poll();

            for(int nbr:adj.get(node)){
                pre[nbr][node]=true;
                for(int i=0;i<numCourses;i++){
                    if(pre[node][i]){
                        pre[nbr][i]=true;
                    }
                }

                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }  

        List<Boolean> res = new ArrayList<>();

        for(int[]qu:queries) {
            int u = qu[0];
            int v = qu[1];

            res.add(pre[v][u]);
        } 

        return res;   
    
}
}