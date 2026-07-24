class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[]indegree= new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge :prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        boolean[][]pre = new boolean[numCourses][numCourses];

        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

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

        List<Boolean> ans = new ArrayList<>();

        for(int []qv:queries){
            int u = qv[0];
            int v = qv[1];
            ans.add(pre[v][u]);
        }

        return ans;
    }
}