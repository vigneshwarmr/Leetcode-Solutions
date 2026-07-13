class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[]vis = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge:prerequisites){
            int course = edge[0];
            int pre = edge[1];
            adj.get(pre).add(course);
        }

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,st))return new int[0];
            }
        }  

        int[]arr= new int[numCourses];

        while(!st.isEmpty()){
            res.add(st.pop());
        }

        for(int i=0;i<numCourses;i++){
            arr[i]=res.get(i);
        }

        return arr;
    }
    private boolean dfs(int node,  List<List<Integer>> adj ,int[]vis,Stack<Integer> st){
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