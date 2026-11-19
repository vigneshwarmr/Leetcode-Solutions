class DSU{
    int[]parent;
    int[]rank;

    public DSU(int n){
        parent= new int[n+1];
        rank = new int[n+1];

        for(int i=0;i<=n;i++){
            rank[i]=1;
            parent[i]=i;
        }
    }

    public int find(int node){
        if(parent[node]!=node){
            parent[node]=find(parent[node]);
        }

        return parent[node];
    }

    public void union(int x,int y){
        int nx= find(x);
        int ny= find(y);

        if(nx== ny)return;

        if(rank[nx]<rank[ny]){
            parent[nx]=ny;
        }else if(rank[ny]<rank[nx]){
            parent[ny]=nx;
        }else{
            parent[nx]=ny;
            rank[nx]++;
        }
        }
    }

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int []edge :edges){
            int root1= dsu.find(edge[0]);
            int root2= dsu.find(edge[1]);

            if(root1==root2)return edge;

            dsu.union(root1,root2);
        }
        return new int[0];
    }
}