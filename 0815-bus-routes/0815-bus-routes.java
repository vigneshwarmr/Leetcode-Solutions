class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        int m = routes[0].length;

        if(source==target)return 0;

        Map<Integer,List<Integer>> map = new HashMap<>();

        Set<Integer> visitedBus = new HashSet<>();
        Set<Integer> visitedStop = new HashSet<>();

        for(int bus=0;bus<n;bus++){
            for(int stop:routes[bus] ){
                map.putIfAbsent(stop,new ArrayList<>());
                map.get(stop).add(bus);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);

        visitedStop.add(source);
        int buses =0;


        while(!q.isEmpty()){
            int size = q.size();
            buses++;

            for(int i=0;i<size;i++){
                int stop = q.poll();

                if(!map.containsKey(stop)) continue;

                for(int bus:map.get(stop)){
                    if(visitedBus.contains(bus))continue;
                    visitedBus.add(bus);

                    for(int nextStop:routes[bus]){
                        if(nextStop==target)return buses;

                        if(!visitedStop.contains(nextStop)){
                            visitedStop.add(nextStop);
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}