class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int[]indegree= new int[numCourses];


        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]p :prerequisites){
            int u = p[0];
            int v= p[1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[][]pre = new boolean[numCourses][numCourses];


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

        List<Boolean> res = new ArrayList<>();

        for(int []qu : queries){
            int t = qu[0];
            int v = qu[1];
            res.add(pre[t][v]);
        }

        return res;
    }
}