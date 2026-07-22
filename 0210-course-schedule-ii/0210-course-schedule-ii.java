class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge :prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        Stack<Integer> st = new Stack<>();
        int []vis = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,st)) return new int[0];
            }
        }
        int[]arr= new int[numCourses];
        int idxx=0;

        while(!st.isEmpty()){
            int node =st.pop();
            arr[idxx++]=node;
        }
        return arr;  
    }

    private boolean dfs(int node,List<List<Integer>> adj,int[]vis ,Stack<Integer> st){
        vis[node]=1;

        for(Integer x:adj.get(node)){
            if(vis[x]==0){
                if(dfs(x,adj,vis,st))return true;
            }else if(vis[x]==1)return true;
        }

        vis[node]=2;
        st.push(node);
        return false;
    }
}