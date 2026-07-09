class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[]vis = new boolean[n];
        Queue<Integer>q = new LinkedList<>();

        q.offer(start);
        vis[start]=true;

        while(!q.isEmpty()){
            int i = q.poll();

            if(arr[i]==0){
                return true;
            }

            int forward = i+arr[i];
            int backward =i- arr[i];

            if(forward<n && !vis[forward]){
                q.offer(forward);
                vis[forward]=true;
            }

            if(backward>=0 && !vis[backward]){
                q.offer(backward);
                vis[backward]=true;
            }
        }      
        return false;
    }
}