class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[]indegree = new int[n];

        for(int[]edge :edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        List<Set<Integer>> ancestors = new ArrayList<>();

        for(int i =0;i<n;i++){
            ancestors.add(new HashSet<>());
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }


        while(!q.isEmpty()){
            int node = q.poll();

            for(int nbr:adj.get(node)){
                ancestors.get(nbr).add(node);
                ancestors.get(nbr).addAll(ancestors.get(node));

                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0;i<n;i++){
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}