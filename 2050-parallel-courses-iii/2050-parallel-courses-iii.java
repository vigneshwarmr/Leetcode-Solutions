class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for(int []edge:relations){
            int u = edge[0]-1;
            int v = edge[1]-1;
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[]maxtime = new int[n];

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
                maxtime[i]= time[i];
            }
        }

        int ans =0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans = Math.max(ans,maxtime[node]);

            for(int nbr:adj.get(node)){
                
                maxtime[nbr]=Math.max( maxtime[nbr], maxtime[node]+time[nbr]);

                indegree[nbr]--;

                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        return ans;


        
    }
}

