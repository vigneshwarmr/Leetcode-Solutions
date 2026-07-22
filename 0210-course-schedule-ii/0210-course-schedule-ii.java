class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[]indegree = new int[numCourses];

        for(int []edge :prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int[]arr= new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node = q.poll();
            arr[index++]=node;
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }

        }

        if(index!=numCourses){
            return new int[0];
        }
        return arr;
        
    }
}