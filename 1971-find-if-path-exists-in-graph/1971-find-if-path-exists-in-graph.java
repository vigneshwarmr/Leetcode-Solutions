class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q= new LinkedList<>();
        q.offer(source);
        boolean[]vis = new boolean[n];

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Integer node= q.poll();
                if(node==destination)return true;

                for(int neighbor:adj.get(node)){
                    if(!vis[neighbor]){
                        vis[neighbor]=true;
                        q.offer(neighbor);
                    }
                }
            }
        }
        return false;
    }
}