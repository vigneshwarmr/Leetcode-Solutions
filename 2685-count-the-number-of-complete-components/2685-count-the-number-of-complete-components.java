class DSU{
    int[]parent;
    int[]rank;
    int components;

    public DSU(int n){
        parent= new int[n];
        rank = new int[n];
        components=n;

        for(int i=0;i<n;i++){
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
            rank[ny]++;
        }
        components--;
    }
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);

        for(int[]edge:edges){
            dsu.union(edge[0],edge[1]);
        }

        int[]vertexCount = new int[n];
        for(int i=0;i<n;i++){
            int root = dsu.find(i);
            vertexCount[root]++;
        }

        int[]edgeCount = new int[n];
        for(int []edge:edges){
            int root = dsu.find(edge[0]);
            edgeCount[root]++;
        }

        int Completecount =0;
        for(int i=0;i<n;i++){
            if(dsu.find(i)==i){
                long m = vertexCount[i];
                long expectedEdges = m*(m-1)/2;
                if(edgeCount[i]==expectedEdges)Completecount++;
            }
        }

    return Completecount;
    }
}