class Solution {
    record Server(long ends,int id){}
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> nextAvailable = new TreeSet<>();
        int[] freq = new int[k];
        int maxReq = 0;
        List<Integer> res = new ArrayList<>();
        Comparator<Server> order = Comparator.comparingLong(Server::ends);
        PriorityQueue<Server> pq = new PriorityQueue<>(order);
        for(int i = 0 ; i < k ; ++i){
            nextAvailable.add(i);
        }
        for(int i = 0 ; i < arrival.length ;  ++i){
            while(!pq.isEmpty() && pq.peek().ends() <= arrival[i]){
                nextAvailable.add(pq.poll().id());
            }
            if(nextAvailable.isEmpty())continue; 
            Integer next = nextAvailable.ceiling(i % k);
            if(next == null){
                next = nextAvailable.first();
            }
            pq.add(new Server(arrival[i] + load[i],next));
            nextAvailable.remove(next);
            freq[next]++;
            if(maxReq < freq[next]){
                maxReq = freq[next];    
            }
        }
        for(int i = 0 ; i < k ; ++i){
            
            if(maxReq == freq[i])res.add(i);
        }
        return res;
    }
}