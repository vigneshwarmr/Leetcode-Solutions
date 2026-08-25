class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        int[]indegree = new int[graph.length];
        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            for(Integer x:graph[i]){
                adj.get(x).add(i);
                indegree[i]++;
            }
        }

        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int nbr:adj.get(node)){
                indegree[nbr]--;

                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}