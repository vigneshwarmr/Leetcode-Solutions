class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<int[]>free = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        PriorityQueue<int[]>busy = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        for(int i = 0;i<n;i++){
            free.add(new int[]{servers[i], i});
        }

        int[]ans = new int[m];

        int t = 0;

        for(int i = 0;i<m;i++){
            t = Math.max(t,i);
            if(free.size()==0)t = busy.peek()[0];

            while(!busy.isEmpty() && busy.peek()[0] <= t){
                int[]c = busy.poll();
                free.add(new int[]{servers[c[1]], c[1]});
            }

            int[] best = free.poll();
            ans[i]=best[1];
            busy.add(new int[]{t+tasks[i], best[1]});
        }

        return ans;
    }
}