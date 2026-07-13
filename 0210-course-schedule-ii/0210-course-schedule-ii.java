class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int []indegree= new int[numCourses];

        for(int []edge:prerequisites){
            int course = edge[0];
            int pre = edge[1];
            adj.get(pre).add(course);
            indegree[course]++;    
        }

        Queue<Integer> q= new LinkedList<>();
        List<Integer> res = new ArrayList<>();

         for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int nbr :adj.get(node)){
                indegree[nbr]--;

                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        int[]arr= new int[res.size()];
        if(res.size()!=numCourses)return new int[0];

        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}