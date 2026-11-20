class DSU{
    int[]parent;
    int[]size;

    public DSU(int n){
        parent= new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int find(int node){
        if(parent[node]!=node){
            parent[node]=find(parent[node]);
        }

        return parent[node];
    }

    public void union(int x,int y){
        int root1= find(x);
        int root2 = find(y);

        if(root1==root2)return;

        if(size[root1]<size[root2]){
            parent[root1]=root2;
            size[root2]+=size[root1];
        }else if(size[root2]<size[root1]){
            parent[root2]=root1;
            size[root1]+=size[root2];
        }else{
             parent[root1]=root2;
            size[root2]++;
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
            int root = dsu.find(i);
            vertexCount[root]++;
        }

        int[]edgeCount = new int[n];
        for(int[]edge:edges){
            int root= dsu.find(edge[0]);
            edgeCount[root]++;
        }

        int FinalCount =0;
        for(int i=0;i<n;i++){
            if(dsu.find(i)==i){
                long m = vertexCount[i];
                long ExpectedEdge = m*(m-1)/2;

                if(edgeCount[i]==ExpectedEdge)FinalCount++;
            }
        }
    return FinalCount;
    }
}