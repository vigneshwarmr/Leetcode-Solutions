class DSU{
    int[]parent;
    int[]rank;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int find(int node){
        if(parent[node]!=node){
            parent[node]=find(parent[node]);
        }
        return parent[node];
    }

    public void union (int x,int y){
        int root1= find(x);
        int root2= find(y);

        if(root1==root2)return;

        if(rank[root1]<rank[root2]){
            parent[root1]=root2;
        }else if(rank[root2]<rank[root1]){
            parent[root2]=root1;
        }else{
            parent[root1]=root2;
            rank[root2]++;
        }
    }
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);

        for(int []edge:edges){
            dsu.union(edge[0],edge[1]);
        }

        int[]vertexCount = new int[n];
        for(int i=0;i<n;i++){
            int root=dsu.find(i);
            vertexCount[root]++;
        }

        int[]edgeCount = new int[n];

        for(int[]edge:edges){
            int edgeh= dsu.find(edge[0]);
            edgeCount[edgeh]++;
        }

        int finalc=0;
        for(int i=0;i<n;i++){
            if(dsu.find(i)==i){
                long m = vertexCount[i];
                long expectedCount = m*(m-1)/2;

                if(edgeCount[i]==expectedCount)finalc++;
            }
        }
        return finalc;
    }
}