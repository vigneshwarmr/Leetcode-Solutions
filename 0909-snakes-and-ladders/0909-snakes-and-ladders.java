class Pair<K,V>{
    K key;
    V value;
    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }

    public K getkey(){
        return key;
    }

    public V getvalue(){
        return value;
    }
}


class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        boolean[]visited = new boolean[n*n +1];
        q.offer(new Pair<>(1,0));
        visited[1]=true;


        while(!q.isEmpty()){
            int square = q.peek().getkey();
            int moves = q.peek().getvalue();
            q.poll();

            if(square==n*n)return moves;

            for(int dice=1;dice<=6 && square +dice<=n*n;dice++){
                int next = square+dice;
                int[]pos = getcordinates(next,n);
                int row = pos[0];
                int col =pos[1];

                if(board[row][col]!=-1){
                    next = board[row][col];
                }
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(new Pair<>(next,moves+1));
                }


            }

        }
        return -1;
    }
    
    private int []getcordinates(int square,int n){
        int row = n-1-(square-1)/n;
        int col =(square-1)%n;

        if(((n-1-row)%2)==1){
            col=n-1-col;
        }

        return new int[]{row,col};

    }
}